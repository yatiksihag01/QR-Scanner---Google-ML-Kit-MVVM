package com.yatik.qrscanner.adapters.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.color.MaterialColors.getColor
import com.yatik.qrscanner.R
import com.yatik.qrscanner.models.food.TableRowData

class FoodTableAdapter(
    private val tableRowsList: List<TableRowData>
) : RecyclerView.Adapter<FoodTableAdapter.FoodTableViewHolder>() {

    inner class FoodTableViewHolder(itemView: View) : ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTableViewHolder {
        return FoodTableViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_food_table, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FoodTableViewHolder, position: Int) {

        val itemView = holder.itemView
        if (position % 2 == 0)
            itemView.setBackgroundColor(getColor(itemView, androidx.appcompat.R.attr.colorPrimary))

        val nutritionType = itemView.findViewById<TextView>(R.id.rv_nutri_type_column)
        val per100Value = itemView.findViewById<TextView>(R.id.rv_per_100_column)
        val perServing = itemView.findViewById<TextView>(R.id.rv_per_serving_column)

        nutritionType.text = tableRowsList[position].nutritionType
        per100Value.text = tableRowsList[position].per100Value
        perServing.text = tableRowsList[position].perServing
    }

    override fun getItemCount(): Int {
        return tableRowsList.size
    }
}