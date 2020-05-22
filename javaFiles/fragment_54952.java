viewHolder.image.setOnClickListener(new View.OnClickListener() {
       @Override
            public void onClick(View v) {
                int previousSelectedItem = selectedItem;
                selectedItem = i;
                notifyItemChanged(previousSelectedItem);     

               viewHolder.image.setBackgroundColor(Color.parseColor("#30000000"));      
            }
        });