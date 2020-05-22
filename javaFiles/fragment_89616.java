@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
    int endMargin = MyApplication.getSharedContext().getResources().getDimensionPixelSize(R.dimen.chat_end_margin);
    int margin = MyApplication.getSharedContext().getResources().getDimensionPixelSize(R.dimen.chat_margin);
    if(viewType == TYPE1)
    {
        ViewGroup parentView = (ViewGroup)parent.getParent();
        CardView.LayoutParams params = (CardView.LayoutParams) (parentView.getLayoutParams());
        params.setMargins(endMargin,margin,margin,margin);
        v.setLayoutParams(params);
    }
    return new ViewHolder(v);
}