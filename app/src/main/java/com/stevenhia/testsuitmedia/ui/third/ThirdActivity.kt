package com.stevenhia.testsuitmedia.ui.third

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stevenhia.testsuitmedia.R
import com.stevenhia.testsuitmedia.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private lateinit var thirdAdapter: ThirdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()

        thirdAdapter = ThirdAdapter()
        setRecyclerView()

    }

    private fun setToolbar() {
        binding.icToolbar.titleToolbar.text = getString(R.string.title_toolbar_third)
        setSupportActionBar(binding.icToolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setRecyclerView() {
        binding.rvUser.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity)
            adapter = thirdAdapter
        }
    }
}