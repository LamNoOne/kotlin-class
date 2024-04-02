package com.example.radio_button

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.radio_button.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        check internet
        if(!Utils.isOnline(this)) {
            val dlg = AlertDialog.Builder(this)
            dlg.setTitle(application.getString(R.string.app_name))
            dlg.setMessage("Your device is not connect to Internet")
            dlg.setCancelable(false)
            dlg.setPositiveButton("OK", { dialog, which ->
                dialog.dismiss()
                finish()
            })
            val dialog = dlg.create()
            dialog.show()
        }
//        edit action bar
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.mipmap.logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
//        event click
//        call activity
        binding.btnStar.setOnClickListener {
            val i = Intent(this, CheckRadioActivity::class.java)
            startActivity(i)
        }
//        call phone
        binding.btnPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + resources.getString(R.string.hotline))
            startActivity(intent)
        }

//        open website
        binding.btnWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(resources.getString(R.string.website))
            startActivity(intent)
        }

//        alert
        binding.btnExit.setOnClickListener {
            val dlg = AlertDialog.Builder(this)
            dlg.setMessage("Exit ? ")
                .setPositiveButton("OK") { dialog, which ->
                    finish()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
            val alert = dlg.create()
            alert.setTitle(R.string.app_name)
            alert.show()
        }
    }
}