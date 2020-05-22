class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
            private LinearLayoutManager manager;

            public Adapter(LinearLayoutManager manager)
            {
                this.manager=manager;
            }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
           ((ViewHolder) holder).txtType.setText(object.text);
           ((ViewHolder) holder).checkBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) { 
                            Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();                           
                          manager.scrollToPosition(position+1);
                        }
                    });
    }