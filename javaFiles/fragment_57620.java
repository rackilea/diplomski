package com.example.ms.inventory_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ms.inventory_app.data.ProductContract.ProductEntry;
import com.example.ms.inventory_app.data.ProductDbHelper;

public class ProductCursorAdapter extends CursorAdapter {

    private LayoutInflater mInflater;
    //private Holder mHolder;

    static private class Holder {
        TextView mSoldTextView;
        TextView mQuantityTextView;
        Button mSaleButton;

        public Holder(View view) {
            mSoldTextView = (TextView) view.findViewById(R.id.product_sold);
            mQuantityTextView = (TextView) view.findViewById(R.id.product_quantity);
            mSaleButton = (Button) view.findViewById(R.id.sale_button);
        }
    }

    public ProductCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        Holder holder = new Holder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, final Cursor cursor) {
        Log.d("Position " + cursor.getPosition() + ":", " bindView() has been called.");

        final Holder holder = (Holder) view.getTag();

        TextView nameTextView = (TextView) view.findViewById(R.id.product_name);
        String name = cursor.getString(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME));
        nameTextView.setText(name);

        TextView priceTextView = (TextView) view.findViewById(R.id.product_price);
        String price = Integer.toString(cursor.getInt(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE)));
        priceTextView.setText(price);

        int quantity = cursor.getInt(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY));
        String quantityText = Integer.toString(quantity);
        holder.mQuantityTextView.setText(quantityText);

        int sold = cursor.getInt(cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_SOLD));
        String soldText = Integer.toString(sold);
        holder.mSoldTextView.setText(soldText);

        final int position = cursor.getPosition();
        holder.mSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.moveToPosition(position);

                int currentSold = Integer.parseInt(holder.mSoldTextView.getText().toString());
                int currentQuantity = Integer.parseInt(holder.mQuantityTextView.getText().toString());

                if (currentQuantity == 0) {
                    Toast.makeText(view.getContext(), "No product available \n Please place order", Toast.LENGTH_SHORT).show();
                    return;
                }

                currentSold+=1;
                currentQuantity-=1;
                holder.mSoldTextView.setText(String.valueOf(currentSold));
                holder.mQuantityTextView.setText(String.valueOf(currentQuantity));

                ProductDbHelper dbHelper = new ProductDbHelper(view.getContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ProductEntry.COLUMN_PRODUCT_SOLD, currentSold);
                values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, currentQuantity);

                long id = cursor.getLong(cursor.getColumnIndex(ProductEntry._ID));
                db.update(ProductEntry.TABLE_NAME, values, "_id=" + id, null);
                db.close();
            }
        });
    }
}