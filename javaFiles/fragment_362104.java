holder.Foto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            if(position==0){
              Intent intent = new Intent(context,MapsActivity.class) // You can get context from onCreateViewHolder, initialize one from parent.getContext() or pass one in constructor of adapter
              startActivity(intent) 

            }else if(position==1){
             // open Second Activity
            }else{
             // open Third Activity
            }

        });