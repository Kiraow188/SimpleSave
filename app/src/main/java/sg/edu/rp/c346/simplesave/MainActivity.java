package sg.edu.rp.c346.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 1b: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 1c: Add the key value pair
        prefEdit.putString("greeting", "Hello!");
        //Step 1d: Call commit() method to save the changes into the SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No greetings!";

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreference object
        String msg = prefs.getString("greeting", "No greetings");

        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
