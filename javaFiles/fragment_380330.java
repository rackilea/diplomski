public class MyRV extends RecyclerView.Adapter<MyRV.ViewHolder> {

private List<MyModelItemWith2Strings> mDataSet; // You may need to setup an array, 
                   // with 2 String objects - for the right and left textviews


// Use an array of class with 2 elements rather than <String>, e.g. List<MyModelItemWith2Strings>
// pass your model here
 // this setData will be used to provide the contents for the textviews
void setData(List< /* set your 2 string class here*/ > dataSet) {
    mDataSet = dataSet;
}

static class ViewHolder extends RecyclerView.ViewHolder {

   // Here you bind item TV's
   // first you declare textviews that you will use to fill with data
   // Add any other item views you will need to fill in

    public TextView tv;
    public TextView tv2;

    public ViewHolder(LinearLayout v) {
        super(v);

        // Bind itemview views here. Put R.id.tv from your itemview.xml

        tv = v.findViewById(R.id.....);
         tv2 = v...
    }
}

// Add your itemview layout here
@Override
public MyRV.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
        .inflate(/***R.layout.item_view***/, parent, false);
    ViewHolder vh = new ViewHolder(v);
    return vh;
}


@Override
public void onBindViewHolder( MyRV.ViewHolder h, int position) {

    // get content from your model (the above list) and fill in the the itemview textviews

    String a= mDataSet.get(position).getItem1();
    String b = mDataSet.get(position). getItem2();
    ...

    h.tv.setText(a);
    // set clickers if you want to. The clicker class is below.
    h.tv.setOnClickListener(new Click(position));

    h.tv2.setText(...)
}

// This is obligatory to pass for your RV to initialize. It won't work if you don' t tell Android how to count your array soze
@Override
public int getItemCount() {
    return mDataSet.size();
}

// These are my implementation of clickers. I prefer to put them in the nested class of the adapter.
private class Click  implements OnClickListener {
    private int pos;
    Click(int position) {
        pos = position;
    }

    @Override
    public void onClick(View p1) {
        // get data from your array on click
        mDataSet.get(pos);
        // Use pos as position on the array, mData.get(pos)
    }
    }
}