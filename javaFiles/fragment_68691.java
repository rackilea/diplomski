holder.cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    dataList.get(holder.getAdapterPosition()).setSelected(isChecked);
                    mOnMyCheckBoxCheckedChangeListener.onMyCheckBoxCheckedChange(); 
            }
        });
    }