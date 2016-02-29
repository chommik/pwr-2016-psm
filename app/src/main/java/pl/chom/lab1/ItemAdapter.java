package pl.chom.lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context context;
    private final List<Item> objects;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
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
        itemImage.setImageResource(thisItem.drawableId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(getContext(), DetailActivity.class);
                detailIntent.putExtra("itemId", thisItem.itemId);
                context.startActivity(detailIntent);
            }
        });

        return convertView;
    }
}
