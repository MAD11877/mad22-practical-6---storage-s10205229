package sg.edu.np.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder2 extends RecyclerView.ViewHolder {

    public View item;
    TextView txt1;
    TextView txt2;
    ImageView image1;
    ImageView image2;

    public ViewHolder2(@NonNull View itemView2) {

        super(itemView2);
        txt1 = itemView2.findViewById(R.id.textView9);
        txt2 = itemView2.findViewById(R.id.textView10);
        image1 = itemView2.findViewById(R.id.imageView9);
        image2 = itemView2.findViewById(R.id.imageView10);

    }

}
