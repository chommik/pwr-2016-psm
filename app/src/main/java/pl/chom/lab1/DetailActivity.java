package pl.chom.lab1;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        int itemId = bundle.getInt("itemId");

        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        TypedArray images = res.obtainTypedArray(R.array.pics);

        setTitle(titles[itemId]);
        ((TextView)findViewById(R.id.detailDescription)).setText(descriptions[itemId]);
        ((ImageView)findViewById(R.id.detailImage)).setImageResource(images.getResourceId(itemId, -1));

        images.recycle();
    }
}
