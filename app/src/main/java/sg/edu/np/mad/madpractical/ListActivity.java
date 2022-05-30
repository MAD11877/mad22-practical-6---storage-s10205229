package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //ArrayList<User> userList = GenerateUsers(200);
        InitRecycler(userList);
    }

    public ArrayList<User> GenerateUsers(int noUsers){
        ArrayList<User> userList = new ArrayList<>();

        for(int userID = 0; userID < noUsers; userID++){
            String username = "Name" + Integer.toString(new Random().nextInt(9999999));
            String desc = "Description" + Integer.toString(new Random().nextInt(9999999));
            // String desc = String.format("Description %d", new Random().nextInt(9999999));
            boolean followed = new Random().nextBoolean();

            User user = new User(username, desc, userID, followed);

            userList.add(user);
        }

        return userList;
    }

    db_handler db = new db_handler(this);
    ArrayList<User> userList = db.getUsers();

    public void InitRecycler(ArrayList<User> userList) {
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);

        BrandsAdapter mAdapter =  new BrandsAdapter(userList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }


}