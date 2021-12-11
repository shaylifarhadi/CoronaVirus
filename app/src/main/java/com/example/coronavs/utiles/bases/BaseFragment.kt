package com.example.coronavs.utiles.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.coronavs.BR


abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutResourceId: Int) :
    Fragment() {

    protected abstract val viewModel: VM
    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<B>(inflater, layoutResourceId, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel,viewModel)
        init()
        observeLiveData()
    }

    abstract fun init()

    fun showMessage(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    open fun observeLiveData() {}

}