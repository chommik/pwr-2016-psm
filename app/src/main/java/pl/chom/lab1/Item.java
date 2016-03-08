package pl.chom.lab1;

import android.widget.ImageView;

public class Item {

    public final int itemId;
    public final String title;
    public final String description;
    public final int drawableId;
    public final int imagesArrayId;

    public Item(int itemId, String title, String description, int drawableId, int imagesArrayId) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.drawableId = drawableId;
        this.imagesArrayId = imagesArrayId;
    }
}
