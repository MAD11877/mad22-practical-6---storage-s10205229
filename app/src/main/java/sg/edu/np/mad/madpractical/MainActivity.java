package sg.edu.np.mad.madpractical;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        private static String TAG = "MainAct";

        // enter data into the class
        User user = new User("name", "description", 10, true);

        @Override // onCreate() belong to AppCompatActivity -> need to override it
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            db_handler db = new db_handler(MainActivity.this);

            Intent i = getIntent();
            Integer idData = i.getIntExtra("id", 0);
            User user = db.oneUser(idData);

            //RECEIVE INFO FRM PREVIOUS PAGE
            String nameData = i.getStringExtra("Username");
            String descData = i.getStringExtra("Description");
            boolean followedData = i.getBooleanExtra("Followed", false);

            // Log.v(TAG, String.format("Name: %s | Desc: %s", nameData, descData));

            TextView username = findViewById(R.id.textView); // find where the name is in the layout
            username.setText(nameData); // set the name to the new name input

            TextView description = findViewById(R.id.textView2); // find where desc is in the layout
            description.setText(descData); // set the desc to the new desc input

            // The button on the left will show “Follow” if the variable followed is false, and vice versa.
            Button followed = findViewById(R.id.button); // find the correct button in the layout
            followed.setText(followedData ? "unfollow": "follow"); // allow the button to switch between the 2 text
            // true = unfollow, false = follow, the '?' acts like a if loop
            // e.g. if followed = true, then return unfollow

            // When the left button is clicked, it will toggle the text between Follow and Unfollow.
            followed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    user.followed = !user.followed; // if value is true, it will change to false
                    followed.setText(user.followed ? "unfollow": "follow");

                    if (user.followed){
                        Toast.makeText(getApplicationContext(), "followed", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "unfollowed", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
}