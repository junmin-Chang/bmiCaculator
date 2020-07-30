package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.preference.Preference
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 이전에 입력한 값을 읽어오기
        loadData()


        resultButton.setOnClickListener {

            // 마지막에 입력한 내용 저장
            saveData(heightEditText.text.toString().toInt(), weightEditText.text.toString().toInt())


            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString(),
                "height" to heightEditText.text.toString()
            )
        }



        }

    private fun saveData(height: Int, weight: Int) {

        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
        editor.putInt("KEY_WEIGHT", weight)
        editor.apply()
    }


    private fun loadData() {
        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if (height != 0 && weight != 0) {
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }

    }


