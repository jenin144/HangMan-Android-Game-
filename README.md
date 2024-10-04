# ASCII Hangman Android Game

                         ![image](https://github.com/user-attachments/assets/9e52d2f5-08ef-4041-a3c0-b9d736e068cf)

**OverView**
```
This project is an Android Studio implementation of the classic Hangman game, where the player tries to guess the word "birzeit"
letter by letter. The game features a simple user interface, tracking wrong guesses by gradually revealing parts of a Hangman figure.
 Below is a summary of the features and functionality:
```

**Features:**

1.Main Activity:
```
A registration form where players enter their first name, last name, and student ID.
A button that starts the game and navigates to the Hangman activity.
```
2.Hangman Activity:
```
Displays an initial blank Hangman figure with no visible parts.
An input field for the player to enter letter guesses.
Displays the Hangman word with hyphens for the unguessed letters (e.g., "-------" for "birzeit").
A text view showing the player's progress and the Hangman figure as they make wrong guesses.
```
**Game Logic:**
```
The word to be guessed is "birzeit" (case-insensitive).
Players can make up to six incorrect guesses, after which the Hangman figure will be fully displayed and the player will lose the game.
Each correct letter guessed updates the word display.
```

**Win/Lose Conditions:**
```
The player wins by correctly guessing all letters of the word.
The player loses after six wrong guesses, completing the Hangman figure.
```
**Restart Option:**
```
After the game ends, players can restart the game, which resets the guessed letters, wrong guesses, and the Hangman figure.
```


You can find the avtivites in : ```HangManGame\app\src\main\java\com\example\a1200540_jenin_mansour```

You can find the XML files in : ```HangManGame\app\src\main\res\layout```


