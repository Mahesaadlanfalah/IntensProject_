package com.example.intensproject_

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intensproject_.R

class MainActivity() : AppCompatActivity(), Parcelable {

    private lateinit var mMessageEditText: EditText

    constructor(parcel: Parcel) : this()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Isi parcel jika diperlukan
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }

        // Deklarasi konstanta di dalam companion object
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        private val LOG_TAG = MainActivity::class.java.simpleName
    }
}
