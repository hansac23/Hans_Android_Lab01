package algonquin.cst2335.vene0018;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

/**
 * This class represents the main activity of the Password Checker app.
 *
 * It allows the user to enter a password and checks if it is complex enough.
 *
 * @author Hansvin Venetheethan
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /*This holds the text at the centre of the screen*/
    private TextView tv = null;
    /*This holds the EditText for entering a password*/
    private EditText editText = null;
    /*This holds the Button for triggering password check*/
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        TextView textView = findViewById(R.id.textview);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Set an OnClickListener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();
                boolean isComplexPassword = checkPasswordComplexity(password);
                TextView textView = findViewById(R.id.textview);

                if (isComplexPassword) {
                    textView.setText("Your password meets the requirements");
                } else {
                    textView.setText("You shall not pass!");
                }
            }
        });
    }

    /**
     * To check the complexity of a given password.
     *
     * This function checks if the provided password contains an uppercase letter, a lowercase letter,
     * a digit, and a special symbol (#$%^*!@?). If any of these requirements are not met,
     * a Toast message is displayed to notify the user about the missing requirement.
     *
     * @param pw The password to check for complexity.
     * @return True if the password is complex enough and false otherwise.
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Your password does not have an upper case letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Your password does not have a lower case letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Your password does not have a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Your password does not have a special symbol", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Check if a character is a special character (#$%^*!@?).
     *
     * @param c The character to check.
     * @return True if the character is a special character; false otherwise.
     */
    private boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '?':
            case '*':
            case '$':
            case '%':
            case '^':
            case '&':
            case '!':
            case '@':
                return true;
            default:
                return false;
        }
    }
}
