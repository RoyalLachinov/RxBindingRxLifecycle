package com.kotlin.rxbindingrxlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

//https://code.tutsplus.com/tutorials/rxjava-for-android-apps-introducing-rxbinding-and-rxlifecycle--cms-28565

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RxView.clicks(button)
            //.debounce(500, TimeUnit.MILLISECONDS)
            .subscribe {
                Toast.makeText(this, "RxView onClick", Toast.LENGTH_LONG).show()
            }

        RxTextView.textChanges(editText)
            .subscribe {
                textView.text = it
            }
    }
}
