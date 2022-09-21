package com.stevenhia.testsuitmedia.ui.second

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stevenhia.testsuitmedia.R
import com.stevenhia.testsuitmedia.databinding.ActivitySecondBinding
import com.stevenhia.testsuitmedia.ui.third.ThirdActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.icToolbar.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        binding.icToolbar.titleToolbar.text = getString(R.string.title_toolbar_second)

        name = intent.getStringExtra(INTENT_DATA)
        if (name != null) {
            binding.tvNameUser.text = name
        }

        binding.buttonChoose.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val INTENT_DATA = "intent_data"
    }
}