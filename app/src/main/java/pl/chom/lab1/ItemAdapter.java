package pl.chom.lab1;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context context;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Item thisItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_single, parent, false);
        }

        TextView itemTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView itemDescription = (TextView) convertView.findViewById(R.id.txtDescription);
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.imageView);

        itemTitle.setText(thisItem.title);
        itemDescription.setText(thisItem.description);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), thisItem.drawableId, options);

        itemImage.setImageResource(thisItem.drawableId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(getContext(), DetailActivity.class);
                detailIntent.putExtra("itemId", thisItem.itemId);
                detailIntent.putExtra("imagesArrayId", thisItem.imagesArrayId);
                context.startActivity(detailIntent);
            }
        });

        return convertView;
    }
}
