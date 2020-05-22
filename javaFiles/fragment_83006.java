for(int i=0;i<list.size();i++){
        if(position==i){
                holder.device.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(list.get(position).flag==true)
                            holder.device.setImageResource(R.drawable.fan_off);
                        else if(list.get(position).flag==false){
                            holder.device.setImageResource(R.drawable.fan_on);
                        }
                    }
                });
            }
    }