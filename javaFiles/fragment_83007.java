// here setTag is used to attach the position with each view being inflated.

holder.device.setTag(position);
holder.device.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        int pos = (int)v.getTag();
        if(list.get(pos).flag==true){
           list.get(pos).flag = false;
          }
        else{
           list.get(pos).flag = true;
          }
     notifyDataSetChanged();
      }

   });

 if(list.get(position).flag == true)
    holder.device.setImageResource(R.drawable.fan_off);
 else
    holder.device.setImageResource(R.drawable.fan_on);