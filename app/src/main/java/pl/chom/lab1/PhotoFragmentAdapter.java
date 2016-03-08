package pl.chom.lab1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class PhotoFragmentAdapter extends FragmentPagerAdapter {

    public PhotoFragmentAdapter(FragmentManager fm, ArrayList<Integer> photos)
    {
        this(fm);
        this.photos = photos;
    }

    public PhotoFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    // FIXME FIXME
    private ArrayList<Integer> photos;

    @Override
    public Fragment getItem(int position) {
        return PhotoFragment.newInstance(photos.get(position));
    }

    @Override
    public int getCount() {
        return photos.size();
    }
}
