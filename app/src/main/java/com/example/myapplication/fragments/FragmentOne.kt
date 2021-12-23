package com.example.myapplication.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class FragmentOne : Fragment(R.layout.fragment_first) {
    private lateinit var editTextNotes: EditText
    private lateinit var buttonAdd: Button
    private lateinit var textViewNotes: TextView
    private lateinit var clearButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextNotes = view.findViewById(R.id.editTextNote)
        buttonAdd = view.findViewById(R.id.buttonAdd)
        textViewNotes = view.findViewById(R.id.textView)
        clearButton = view.findViewById(R.id.clearButton)

        val sharedPreferences = requireActivity().getSharedPreferences("APP_PR",
            Context.MODE_PRIVATE
        )
        val notes = sharedPreferences.getString("notes", "")

        textViewNotes.text = notes

        buttonAdd.setOnClickListener {
            val note = editTextNotes.text.toString()
            val text = textViewNotes.text.toString()
            val result = "$note \n $text"

            textViewNotes.text = result

            sharedPreferences.edit()
                .putString("notes", result)
                .apply()
        }

        clearButton.setOnClickListener {
            Toast.makeText(context,"Your Notes Will Clear on Next Application Run",Toast.LENGTH_SHORT).show()
            sharedPreferences.edit()
                .clear()
                .apply()

        }
    }
}

