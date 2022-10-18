package com.example.labwork1

import CustomPassword
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.passwordInput)
        findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { group, id ->
            if (id == R.id.radioShow){
                editText.inputType = InputType.TYPE_CLASS_TEXT
                editText.transformationMethod = null
            }
            else{
                editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                editText.transformationMethod = CustomPassword()
            }
            editText.setSelection(editText.text.length)
        }
    }

    fun showText(view: View){
        val text = findViewById<EditText>(R.id.passwordInput).text.toString()
        when {
            text.isEmpty() -> {
                Toast.makeText(this, "Input any text!", Toast.LENGTH_SHORT).show()
            }
            text.all { it.isLetter() } -> {
                Toast.makeText(this, "Your password must contain both letters and numbers", Toast.LENGTH_SHORT).show()

            }
            text.all { it.isDigit() } -> {
                Toast.makeText(this, "Your password must contain both letters and numbers", Toast.LENGTH_SHORT).show()
            }
            else -> {
                findViewById<TextView>(R.id.textResult).text = text
                findViewById<EditText>(R.id.passwordInput).setText("")
            }
        }
    }

    fun clearText(view: View){
        findViewById<TextView>(R.id.textResult).text = ""
        findViewById<EditText>(R.id.passwordInput).setText("")
    }

    fun clickInf(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Information")
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        val text = TextView(this)
        text.text = resources.getString(R.string.variant)
        text.textSize = 18f
        text.setPadding(50, 10, 30, 10);
        layout.addView(text)
        builder.setView(layout)
        builder.setNegativeButton("OK") { _, _ -> }
        builder.show()
    }
}