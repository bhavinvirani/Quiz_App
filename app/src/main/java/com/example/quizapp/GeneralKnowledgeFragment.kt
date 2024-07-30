package com.example.quizapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.quizapp.R

class GeneralKnowledgeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_general_knowledge, container, false)

        // Initialize UI elements and set up interactions
        val questionTextView: TextView = view.findViewById(R.id.question_text_view)
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)
        val submitButton: Button = view.findViewById(R.id.submit_button)

        questionTextView.text = "What is the capital of France?"
        val answerOptions = arrayOf("Berlin", "Madrid", "Paris", "Rome")
        for (option in answerOptions) {
            val radioButton = RadioButton(context)
            radioButton.text = option
            radioGroup.addView(radioButton)
        }

        submitButton.setOnClickListener {
            val selectedOption = radioGroup.checkedRadioButtonId
            if (selectedOption != -1) {
                val answer = view.findViewById<RadioButton>(selectedOption)
                if (answer.text == "Paris") {
                    questionTextView.text = "Correct!"
                } else {
                    questionTextView.text = "Wrong! The correct answer is Paris."
                }
            }
        }

        return view
    }
}