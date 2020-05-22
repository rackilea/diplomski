@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    int viewType=holder.getItemViewType();
    switch (viewType){
        // ...
        case TYPE_EXPANDABLE:
            Phonecall call = (Phonecall) myArrayList.get(position);
            ((CallViewHolder)holder).bind(call);
            break;
        // ...