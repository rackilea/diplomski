viewHolder.cb_selection.setChecked(booksInfo.isChecked);
viewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booksInfo.isChecked = !booksInfo.isChecked;
                viewHolder.cb_selection.setChecked(booksInfo.isChecked);
                if (booksInfo.isChecked){
                    onItemCheckListener.onItemCheck(booksInfo,viewHolder);
//                    viewHolder.tv_qty.setText(qty);
                }else{
                    onItemCheckListener.onItemUncheck(booksInfo,viewHolder);
//                    viewHolder.tv_qty.setText("0");
                }

            }
        });