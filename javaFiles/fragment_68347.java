@Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelClass2 modelClass2=itemlist2.get(position);


        holder.textView.setText(itemlist2.get(position).getName());
        holder.imageView.setImageResource(R.drawable.pic2); <-----------

    }