package ucll.java.mobile.ucll_gip5_groep7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Params for views and logs
    private static final String TAG = "MainActivity";
    private TextView loginTitle;
    private EditText username;
    private EditText password;
    private Button signIn;
    private TextView registerHere;
    private TextView forgotPassword;

    // Param for Alert dialog and login attempts
    private int signInAttempts = 3;
    private AlertDialog.Builder builder;

    // Initiate app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initiate start application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Application run successful!");

        // All names and id's from the MainActivity View
        loginTitle = findViewById(R.id.loginTitle);
        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        signIn = findViewById(R.id.signIn);
        registerHere = findViewById(R.id.registerHere);
        forgotPassword = findViewById(R.id.forgotPassword);

        // create alert screen
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.alertTitleMain);
        builder.setMessage(R.string.alertMsgMain);
        builder.setNegativeButton("Leave app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishActivity(0);
                System.exit(0);
            }
        });

        // Event when user is clicking on button
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //login is successful!
                    Toast.makeText(MainActivity.this, "Logging succesfull!", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "Logging in successful!");
                    homeScreen(v);
                }else{
                    //login failed!
                    Toast.makeText(MainActivity.this, "Logging failed!", Toast.LENGTH_LONG).show();
                    signInAttempts --;
                    Log.e(TAG, "Failed to log in!");
                    if(signInAttempts == 2 || signInAttempts == 1){
                        Toast.makeText(MainActivity.this, "You have " + signInAttempts + "attemps to log in",
                                Toast.LENGTH_LONG).show();
                        Log.d(TAG, "Logging attempts: " + signInAttempts);
                    }
                    if(signInAttempts == 0){
                        // if password is wrong for 3 times
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        Log.e(TAG, "All login tokens expired. Account user is blocked.");
                    }
                }
            }
        });
    }

    public void homeScreen(View view){
        Intent intentHome = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intentHome);
        Log.d(TAG, "Intent to home page successful");
    }
}