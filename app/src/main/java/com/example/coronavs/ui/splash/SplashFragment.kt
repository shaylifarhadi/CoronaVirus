package com.example.coronavs.ui.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coronavs.R
import com.example.coronavs.databinding.SplashFragmentBinding
import com.example.coronavs.utiles.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentBinding,SplashViewModel>(R.layout.splash_fragment) {
    override val viewModel: SplashViewModel by viewModels()

    override fun init() {

        binding.viewModel = viewModel
    }

    override fun observeLiveData() {
        super.observeLiveData()

        viewModel.isTimerFinished.observe(viewLifecycleOwner){
            if (it) openCoronaFragment()
        }
    }

    private fun openCoronaFragment() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToCoronaFragment())
    }


}