viewHolder.text.setTag(info)
   viewHolder.text.setClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {  
           DataSource info = (DataSource)v.getTag(); 
           data.add(info);
           notifyDataSetChanged(); 

         }
       });