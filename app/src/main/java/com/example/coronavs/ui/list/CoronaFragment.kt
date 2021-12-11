package com.example.coronavs.ui.list

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.example.coronavs.R
import com.example.coronavs.databinding.CoronaFragmentBinding
import com.example.coronavs.network.datamodel.Country
import com.example.coronavs.network.erorhandling.Status
import com.example.coronavs.utiles.bases.BaseFragment
import com.example.coronavs.utiles.bases.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoronaFragment : BaseFragment<CoronaFragmentBinding,BaseViewModel>(R.layout.corona_fragment) {
    override val viewModel: CoronaViewModel by viewModels()


    lateinit var adapter: CoronaAdapter

    override fun init() {
        search()
        setBackgroundConfirm()
        setBackgroundDeath()
        setBackgroundRecover()
    }
    override fun observeLiveData() {
        super.observeLiveData()

        viewModel.responseCorona.observe(viewLifecycleOwner){ it ->
            if (it.status == Status.ERROR){
                showMessage(it.message.orEmpty())
            }else{
                it.data?.countries?.let {
                    createRecycler(it)
                    viewModel.list = it

                }
            }
        }
    }

    private fun createRecycler(it: List<Country>) {
        adapter = CoronaAdapter(it,requireContext())

        binding.rvCorona.adapter = adapter
    }

    private fun search(){
        binding.etSearch.addTextChangedListener {
            val newList = viewModel.list.filter { it.slug?.contains(binding.etSearch.text.toString()) ?: false }
            createRecycler(newList)
        }
    }

    private fun setBackgroundConfirm(){
        binding.tvMostConfirm.setOnClickListener {
            changeTextViewConfirm()
            val list2 = viewModel.list.sortedByDescending { it.newConfirmed }
            createRecycler(list2)
        }
    }

    private fun setBackgroundDeath(){
        binding.tvMostDeath.setOnClickListener {
            changeTextViewDeath()
            val list3 = viewModel.list.sortedByDescending { it.newDeaths }
            createRecycler(list3)
        }
    }


    private fun setBackgroundRecover(){
        binding.tvMostRecover.setOnClickListener {
            changeTextViewRecover()
            val list4 = viewModel.list.sortedByDescending { it.newRecovered }
            createRecycler(list4)
        }
    }

    private fun changeTextViewConfirm() {
        binding.tvMostConfirm.setBackgroundResource(R.color.gray_100)
        binding.tvMostDeath.setBackgroundResource(R.color.white)
        binding.tvMostRecover.setBackgroundResource(R.color.white)
    }

    private fun changeTextViewRecover() {
        binding.tvMostRecover.setBackgroundResource(R.color.gray_100)
        binding.tvMostDeath.setBackgroundResource(R.color.white)
        binding.tvMostConfirm.setBackgroundResource(R.color.white)
    }

    private fun changeTextViewDeath() {
        binding.tvMostDeath.setBackgroundResource(R.color.gray_100)
        binding.tvMostConfirm.setBackgroundResource(R.color.white)
        binding.tvMostRecover.setBackgroundResource(R.color.white)
    }



}