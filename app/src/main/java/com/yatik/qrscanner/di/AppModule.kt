package com.yatik.qrscanner.di

import android.content.Context
import androidx.room.Room
import com.yatik.qrscanner.database.BarcodeDao
import com.yatik.qrscanner.database.BarcodeRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBarcodeDatabase(
        @ApplicationContext appContext: Context
    ) = Room.databaseBuilder(
        appContext,
        BarcodeRoomDataBase::class.java,
        "barcode_database"
    ).build()

    @Provides
    @Singleton
    fun provideBarcodeDao(database: BarcodeRoomDataBase): BarcodeDao {
        return database.barcodeDao()
    }

}