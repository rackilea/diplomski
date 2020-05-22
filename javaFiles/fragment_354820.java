@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


    switch(getItemViewType(position)){

        case 1: //for layout 1
            ((ViewHolder_LayoutOne)holder).name.setText("");
            break;

        case 2:// for layout 2
            ((ViewHolder_LayoutTwo)holder).name.setText("");
            break;
    }
}