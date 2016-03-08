package pl.chom.lab1;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        int imagesArrayId = bundle.getInt("imagesArrayId");
        int itemId = bundle.getInt("itemId");

        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        TypedArray images = res.obtainTypedArray(R.array.pics);

        setTitle(titles[itemId]);
        ((TextView)findViewById(R.id.detailDescription)).setText(descriptions[itemId]);

        TypedArray typedArray = res.obtainTypedArray(imagesArrayId);

        ArrayList<Integer> resourceArray = new ArrayList<>();
        for (int i = 0; i < typedArray.length(); i++)
        {
            resourceArray.add(typedArray.getResourceId(i, -1));
        }
        typedArray.recycle();

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new PhotoFragmentAdapter(getSupportFragmentManager(), resourceArray));

        images.recycle();
    }
}
