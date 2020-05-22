LayoutInaflater inflater;
public ReceiptAdapter(Context context, int resource) {
            super(context, resource);
            mContext = context;
            mResource = resource;
            infalter= LayoutInflater.from(context);
        }