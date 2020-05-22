MyAdapterClickInterface checkedListener;
public MyFunDapter(Context context, List<T> dataItems, int layoutResource,
                       LongExtractor<T> idExtractor, BindDictionary<T> dictionary, MyAdapterClickInterface checkedListener) {
        this.mContext = context;
        this.checkedListener = checkedListener; //making use of interface instance
...
}