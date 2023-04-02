package com.yatik.qrscanner.repository

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DefaultGeneratorRepository @Inject constructor(
    @ApplicationContext val context: Context
) : GeneratorRepository {

    override suspend fun saveImageToGallery(bitmap: Bitmap): Boolean {
        val resolver = context.contentResolver
        val imageCollection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageName = "QRCode_$timeStamp.jpg"
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, imageName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.WIDTH, bitmap.width)
            put(MediaStore.Images.Media.HEIGHT, bitmap.height)
        }
        return try {
            resolver.insert(imageCollection, contentValues)
                ?.also { resultUri ->
                    resolver.openOutputStream(resultUri)?.use { outputStream ->
                       if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)) {
                           throw IOException("Unable to save bitmap")
                       }
                    }
                } ?: throw IOException("Unable to create MediaStore entry")
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

}