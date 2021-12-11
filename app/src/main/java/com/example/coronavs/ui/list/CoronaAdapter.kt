package com.example.coronavs.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavs.R
import com.example.coronavs.databinding.ItemCoronaBinding
import com.example.coronavs.network.datamodel.Country

class CoronaAdapter(private val countryList: List<Country>, private val context: Context) :
    RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaViewHolder {
        val binding = ItemCoronaBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return CoronaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoronaViewHolder, position: Int) {
        val item = countryList[position]
        holder.binding.apply {
            tvConfirm.text = context.getString(R.string.newConfirmed, item.newConfirmed)
            tvDeath.text = context.getString(R.string.newDeath, item.newDeaths)
            tvRecover.text = context.getString(R.string.newRecovered, item.newRecovered)
            tvCountry.text = item.country.toString()
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    inner class CoronaViewHolder(val binding: ItemCoronaBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}