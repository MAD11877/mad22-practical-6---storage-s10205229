package sg.edu.np.mad.madpractical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class BrandsAdapter extends RecyclerView.Adapter<ViewHolder2> {
    ArrayList<User> data;

    public BrandsAdapter(ArrayList<User> input) {
        data = input;
    }

    @Override
    public int getItemViewType(int position) {

        String name = data.get(position).name;

        return "7".equals(name.substring(name.length() - 1)) ? 1:0; // IF ELSE
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item =  null;

        if (viewType == 1) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.viewlayout2,
                    parent,
                    false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.viewlayout,
                    parent,
                    false);
        }

        return new ViewHolder2(item);
    }

    // Runs when loading in new data
    // E.g We have 100 views, but recycler will only show the first 10
    // when you scroll down the list to "load" in more views, calls this method
    // to bind the data to the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        User userData = data.get(position);
        holder.txt1.setText(userData.name);
        holder.txt2.setText(userData.description);

        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog
                        .Builder(view.getContext())
                        .setTitle("Profile")
                        .setMessage(String.format("%s", userData.name))
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent MainActivity = new Intent(view.getContext(), MainActivity.class);
                                MainActivity.putExtra("Username", userData.name);
                                MainActivity.putExtra("Description", userData.description);
                                MainActivity.putExtra("Followed", userData.followed);

                                view.getContext().startActivity(MainActivity);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .create()
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}