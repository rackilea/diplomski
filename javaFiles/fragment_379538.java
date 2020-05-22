holder.container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (ma.mActionMode == null) {


                    // the line that triggers it  
                    ma.receiptGridView.setItemChecked(position, true);


                    v.setBackgroundResource(b ? R.color.color_ce5a5a : R.drawable.receipt_item_bg);
                    view.setBackgroundColor(Color.parseColor("#ce5a5a"));
                }
                return false;
            }
        });