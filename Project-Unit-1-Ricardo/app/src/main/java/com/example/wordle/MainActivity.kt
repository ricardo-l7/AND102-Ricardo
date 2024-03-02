package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    var count = 0 // number of user's guesses

    // given function to guess user's check
    override fun onCreate(savedInstanceState: Bundle?) {
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            count++
            if (count > 3) {
                // if user has already guessed 3 times do not let them guess again
                Toast.makeText(this, "No more guesses allowed", Toast.LENGTH_SHORT).show()
            }
            else {
                // get the user's guess
                val userCurrentGuess = findViewById<EditText>(R.id.user_guess);
                val strGuess = userCurrentGuess.text.toString().uppercase();

                if (strGuess.length != 4) {
                    // if the user's guess isn't a 4-letter word, let them reguess
                    Toast.makeText(this, "Please enter a 4 letter word", Toast.LENGTH_SHORT).show()
                    count--
                }

                // for each guess: (1) check it, (2) display the guess, (3) display the check
                else if (count == 1) {
                    val checkedStr = checkGuess(strGuess)
                    val userGuess1View = findViewById<TextView>(R.id.userGuess1);
                    userGuess1View.text = strGuess
                    userGuess1View.visibility = View.VISIBLE
                    val checkGuess1View = findViewById<TextView>(R.id.checkGuess1)
                    checkGuess1View.text = checkedStr
                    checkGuess1View.visibility = View.VISIBLE
                }
                else if (count == 2) {
                    val checkedStr = checkGuess(strGuess)
                    var userGuess2View = findViewById<TextView>(R.id.userGuess2);
                    userGuess2View.text = strGuess
                    userGuess2View.visibility = View.VISIBLE
                    val checkGuess2View = findViewById<TextView>(R.id.checkGuess2)
                    checkGuess2View.text = checkedStr
                    checkGuess2View.visibility = View.VISIBLE
                }
                else if (count == 3) {
                    val checkedStr = checkGuess(strGuess)
                    var userGuess3View = findViewById<TextView>(R.id.userGuess3);
                    userGuess3View.text = strGuess
                    userGuess3View.visibility = View.VISIBLE
                    val checkGuess3View = findViewById<TextView>(R.id.checkGuess3)
                    checkGuess3View.text = checkedStr
                    checkGuess3View.visibility = View.VISIBLE
                    val randomWordView = findViewById<TextView>(R.id.randomWord)
                    randomWordView.text = "Correct Word = $wordToGuess"
                    randomWordView.visibility = View.VISIBLE
                }
            }
        }
    }
}