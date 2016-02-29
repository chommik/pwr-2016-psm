package pl.chom.lab1;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        TypedArray images = res.obtainTypedArray(R.array.pics);
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            items.add(new Item(i, titles[i], descriptions[i], images.getResourceId(i, -1)));
        }

        ArrayAdapter<Item> adapter = new ItemAdapter(this, R.layout.item_single, items);

        ListView listView = (ListView) findViewById(R.id.itemList);
        listView.setAdapter(adapter);

        images.recycle();
    }
}