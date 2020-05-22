private final MarketsItemsClickListener mItemsClickListener;
private final MarketLongClickListener mLongClickListener;
private final MarketClickListener mClickListener;
private final String mTag;

public MarketAdapter(Context context, MarketsItemsClickListener itemsClickListener, MarketClickListener clickListener, MarketLongClickListener longClickListener, String tag){
    mTag = tag
    mContext = context;
    mItemsClickListener = itemsClickListener;
    mLongClickListener = longClickListener;
    mClickListener = clickListener;
}