package com.app.beautysaloon;


import com.app.beautysaloon.Models.Orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;


public class CheckOutAdapter extends ArrayAdapter<Orders> {


    List<Orders> i_List;
    LayoutInflater inflater;
    Context context123;
    ViewHolder holder;

    public CheckOutAdapter(Context context, List<Orders>Orders ) {


        super(context, R.layout.checkout_screen_for_addition,Orders
        );
        // TODO Auto-generated constructor stub
        context123 = context;
        i_List = Orders;


        context123 = context;
        inflater = LayoutInflater.from(context);
        i_List = Orders;
    }

    public class ViewHolder {
        TextView item_name, item_quantity, item_description, item_price;
        Button add_btn, subtract_btn;
    }

    @Override
    public View getView(final int position, View convertView,
                        ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            inflater = LayoutInflater.from(context123);
            convertView = inflater.inflate
                    (R.layout.checkout_screen_for_addition, null);
        }

        holder = new ViewHolder();

        holder.item_name = (TextView) convertView.findViewById
                (R.id.item_name_tv);
        holder.item_quantity = (TextView) convertView.findViewById
                (R.id.item_quantity_tv);
        holder.item_description = (TextView) convertView.findViewById
                (R.id.description_tv_edt);
        holder.item_price = (TextView) convertView.findViewById
                (R.id.price_tv_edt);
        holder.add_btn = (Button) convertView.findViewById
                (R.id.add_btn);
        holder.subtract_btn = (Button) convertView.findViewById
                (R.id.subtract_btn);

        holder.item_name.setText(i_List.get(position).getItem_name());
        holder.item_quantity.setText(""+i_List.get(position).getItem_quantity());
        holder.item_description.setText(i_List.get(position).getItem_description());
        holder.item_price.setText("Rs." + i_List.get(position).getItem_price());

        //Creating Click listner of every item
        holder.add_btn.setOnClickListener(new OnItemClickListener(position, holder.item_quantity,"+"));
        holder.subtract_btn.setOnClickListener(new OnItemClickListener(position, holder.item_quantity,"-"));

        return convertView;
    }

    //That is the class which use to change value on Item click listner.

    private class OnItemClickListener  implements  View.OnClickListener {

        private int mPosition;
        private TextView tv;
        String sin;

        OnItemClickListener(int position,TextView tvs,String sing){
            mPosition = position;
            tv=tvs;
            sin=sing;
        }

        @Override
        public void onClick(View v) {
            int q= CheckOut.orders_list.get(mPosition).getItem_quantity();
            if(sin.equals("+")){
                q++;
            }else if(sin.equals("-")){
                q--;
            }
            CheckOut.orders_list.get(mPosition).setItem_quantity(q);
            tv.setText(""+q);

        }
    }
}