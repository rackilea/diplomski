public class StoresAdapter extends ArrayAdapter<Stores> {


    OnclickListener mListener = null  ;


    public interface OnclickListener {

        void onMapButtonClick(int position);
        void onCallButtonClick(int position);
    }


    public StoresAdapter(Context context, ArrayList<Stores> stores, OnclickListener listener) {
        super(context, 0, stores);
        mListener = listener ;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        super.getView(position, convertView, parent);

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.dist_layout, parent, false);
        }

        Stores currentStore = getItem(position);

        Stores currentStores = getItem(position);

        TextView storeName = (TextView) listItemView.findViewById(R.id.storeName);
        storeName.setText(currentStores.getStoreName());

        ImageView storeImage = (ImageView) listItemView.findViewById(R.id.storeImage);
        storeImage.setImageResource(currentStores.getStoreImageResourceId());

        ImageButton callButton = (ImageButton) listItemView.findViewById(R.id.callButton);
        callButton.setImageResource(currentStores.getStoreMobileButton());

        ImageButton mapButton = (ImageButton) listItemView.findViewById(R.id.mapButton );
        mapButton.setImageResource(currentStores.getStoreAddressButton());

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onMapButtonClick(position);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCallButtonClick(position);
            }
        });

        return listItemView;
    }
}