package com.rubabe.jokesapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import com.rubabe.jokesapp.databinding.ActivityMainBinding
import com.rubabe.jokesapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var spinner: ProgressBar
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        spinner = findViewById(R.id.progressBar)
        spinner.visibility = View.VISIBLE
        viewModel.getJokes(this)

        viewModel.jokesLiveData.observe(this) {
            spinner.visibility = View.GONE
            binding.jokesTextView.text = viewModel.jokesLiveData.value?.setup
        }
    }

}