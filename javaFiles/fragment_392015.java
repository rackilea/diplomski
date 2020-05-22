holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(holder.checkBox.isChecked()){
            checkedListener.itemChecked(position);
            //or some other method to save your checks..
            }