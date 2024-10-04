package com.example.a1200540_jenin_mansour;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private static final String word = "birzeit";
    private int wrongGuesses;
    private int rightGuesses;

    private TextView[] hangmanParts;
    private TextView wrongGuessesTextView, ResultTextView, studentInfoTextView;
    private TextView[] letterTextViews = new TextView[7]; // TextViews for each letter of the word
    private EditText Input;
    private Button guessButton, restartButton;
    private String firstName, lastName, studentId;
    private StringBuilder wrongGuessesLetters;
    private ArrayList<Character> guessedLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        hangmanParts = new TextView[] {
                findViewById(R.id.head),
                findViewById(R.id.body),
                findViewById(R.id.rightArm),
                findViewById(R.id.leftArm),
                findViewById(R.id.rightLeg),
                findViewById(R.id.leftLeg)
        };

        // Letter TextViews
        letterTextViews[0] = findViewById(R.id.letter0);
        letterTextViews[1] = findViewById(R.id.letter1);
        letterTextViews[2] = findViewById(R.id.letter2);
        letterTextViews[3] = findViewById(R.id.letter3);
        letterTextViews[4] = findViewById(R.id.letter4);
        letterTextViews[5] = findViewById(R.id.letter5);
        letterTextViews[6] = findViewById(R.id.letter6);

        wrongGuessesTextView = findViewById(R.id.wrongGuessesletters);
        ResultTextView = findViewById(R.id.ResultText);
        ResultTextView = findViewById(R.id.ResultText);
        studentInfoTextView = findViewById(R.id.studentInfo);
        Input = findViewById(R.id.enter_letter);
        guessButton = findViewById(R.id.guessButton);
        restartButton = findViewById(R.id.restartButton);

        // Get student information from MainActivity
        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        studentId = getIntent().getStringExtra("studentId");

        // Display student info
        String studentInfo = "ASCII Hangman Activity\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "ID: " + studentId;
        studentInfoTextView.setText(studentInfo);

        reset();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letters = Input.getText().toString().toLowerCase();

                if(letters.length() != 1){
                    Toast.makeText(GameActivity.this, "Please enter a single letter!!", Toast.LENGTH_SHORT).show();
                }
                else if(!Character.isLetter(letters.charAt(0))){
                    Toast.makeText(GameActivity.this, "Please enter a valid letter!!", Toast.LENGTH_SHORT).show();
                }
                else{

                    char letter = letters.charAt(0);
                    if (guessedLetters.contains(letter)) {
                        Toast.makeText(GameActivity.this, "You have already guessed that letter: " + letter, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    guessedLetters.add(letter);

                    int Guessed = 0;
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == letter) {
                            letterTextViews[i].setText(String.valueOf(letter));
                            Guessed = 1;
                            rightGuesses++; // Increment right guesses
                        }
                    }

                    if (Guessed == 0 ) {
                        wrongGuesses++;
                        wrongGuessesLetters.append(letter).append(" ");
                        wrongGuessesTextView.setText("Wrong guesses: " + wrongGuessesLetters.toString());
                        //update figure
                        if (wrongGuesses > 0 && wrongGuesses <= hangmanParts.length) {
                            hangmanParts[wrongGuesses - 1].setVisibility(View.VISIBLE);
                        }
                    }

                    if (rightGuesses == word.length() ) {
                        ResultTextView.setText("Congratulations, " + firstName + " " + lastName + "! You won the game!");
                        guessButton.setEnabled(false);
                    } else if (wrongGuesses >= 6) {
                        ResultTextView.setText("Sorry, " + firstName + " " + lastName + "! You lost the game.");
                        guessButton.setEnabled(false);
                    }

                }
                Input.setText("");
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void reset() {
        wrongGuesses = 0;
        rightGuesses = 0;
        wrongGuessesLetters = new StringBuilder();
        guessedLetters = new ArrayList<>();

        for (TextView part : hangmanParts) {
            part.setVisibility(View.INVISIBLE);
        }

        for (TextView textView : letterTextViews) {
            textView.setText("_");
        }

        wrongGuessesTextView.setText("Wrong guesses: ");
        ResultTextView.setText("");
        guessButton.setEnabled(true);
    }


}
