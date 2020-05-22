private OnQuantityChangeListener mListener;

public InvoiceRecyclerViewAdapter(Context mContext,List<Products> addedProductsList, OnQuantityChangeListener listener) {
    this.mContext=mContext;
    this.addedProductsList=addedProductsList;
    mListener = listener;

}
public InvoiceRecyclerViewAdapter(Context mContext, OnQuantityChangeListener listener)
{
    this.mContext=mContext;
    mListener = listener;
}