import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Bitmap> bitmaps;
    private int imageWidth;

    public ImageGridViewAdapter (Context c, ArrayList<Bitmap> bitm, int width) {
        this.mContext = c;
        this.bitmaps = bitm;
        this.imageWidth = width;
    }

    public int getCount() 
    {
        return bitmaps.size();
    }

    public Object getItem(int position) {
        return bitmaps.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) 
        {
            imageView = new ImageView(mContext);
        } 
        else 
        {
            imageView = (ImageView) convertView;
        }

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageWidth));
        imageView.setImageBitmap(bitmaps.get(position));

        return imageView;
    }

}