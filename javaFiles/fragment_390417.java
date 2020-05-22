final int pos=position;
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listData.get(pos).isSelected=!listData.get(posi).isSelected;
                notifyDataSetChanged();
            }
        });