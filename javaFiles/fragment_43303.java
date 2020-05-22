import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class RVAdapter extends RecyclerViewCursorAdapter<RVAdapter.ProductViewHolder>
{
    private static final String TAG = RVAdapter.class.getSimpleName();
    private final Context mContext;
    private final Random mRandom;


    public RVAdapter(Context context, String locationSetting)
    {
        super(null);
        mContext = context;
        mRandom  = new Random(System.currentTimeMillis());

        // Sort order:  Ascending, by date.
        String sortOrder = ProductContract.ProductEntry.COLUMN_DATE + " ASC";
        Uri productForLocationUri = ProductContract.ProductEntry
            .buildProductLocationWithStartDate(locationSetting, System.currentTimeMillis());

        // Students: Uncomment the next lines to display what what you stored in the bulkInsert
        Cursor cursor = mContext.getContentResolver()
            .query(productForLocationUri, null, null, null, sortOrder);

        swapCursor(cursor);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(ProductViewHolder holder, Cursor cursor)
    {
        String imagePath = cursor.getString(ShopFragment.COL_PRODUCT_IMAGE);
        String price = cursor.getString(ShopFragment.COL_PRODUCT_PRICE);

        holder.productPrice.setText("US $" + price);

        int height = mRandom.nextInt(50) + 500;

        //Download image using picasso library
        Picasso.with(mContext)
            .load(imagePath)
            .resize(500, height)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(holder.productPhoto);
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        CardView cv;
        TextView productPrice;
        ImageView productPhoto;

        ProductViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            productPrice = (TextView) itemView.findViewById(R.id.product_price);
            productPhoto = (ImageView) itemView.findViewById(R.id.product_photo);
        }
    }
}