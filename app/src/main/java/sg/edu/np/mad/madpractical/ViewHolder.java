package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public View item;
    TextView txt1;
    TextView txt2;
    ImageView image1;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        txt1 = itemView.findViewById(R.id.textView9);
        txt2 = itemView.findViewById(R.id.textView10);
        image1 = itemView.findViewById(R.id.imageView9);
    }
}