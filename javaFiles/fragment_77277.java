@Override
    public void bindViewHolder(ViewHolder holder, int position) {
        if(position == separatorPosition){
           holder.separatorView.visible = View.VISIBLE;
        }else{
           holder.separatorView.visible = View.GONE;
        }
    }