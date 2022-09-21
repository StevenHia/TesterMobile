package com.stevenhia.testsuitmedia.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.stevenhia.testsuitmedia.R
import com.stevenhia.testsuitmedia.databinding.ActivityMainBinding
import com.stevenhia.testsuitmedia.ui.second.SecondActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionButton()
    }

    private fun isPalindromeText(text: String): Boolean {
        val reverseString = text.reversed()
        return text.equals(reverseString, ignoreCase = true)
    }


    private fun setActionButton() {
        binding.buttonCheck.setOnClickListener {
            validationPalindrome()
        }

        binding.buttonNext.setOnClickListener {
            validationText()
        }
    }

    private fun validationText() {
        val name = binding.edtName.text.toString()

        if (name.length < 2) {
            binding.edtName.error = "Minimal 2 Character"
        } else if (name.length > 255) {
            binding.edtName.error = "Maximal 255 Character"
        } else {
            var intent = Intent(this, SecondActivity::class.java)
            intent = intent.putExtra(SecondActivity.INTENT_DATA, name)
            startActivity(intent)
            this.finish()
        }
    }


    private fun validationPalindrome() {
        val textPal = binding.edtPalindrome.text.toString()
        if (textPal != "") {
            if (isPalindromeText(textPal)) {
                showAlertDialog(true)
            } else {
                showAlertDialog(false)
            }
        } else {
            binding.edtPalindrome.error = "Please Input Text"
        }


    }

    private fun showAlertDialog(isPalindrome: Boolean) {
        if (isPalindrome) {
            Toast.makeText(this, R.string.message_palindrome_true, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.message_palindrome_false, Toast.LENGTH_SHORT).show()
        }
    }
}