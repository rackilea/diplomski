box.setText(todo); 
box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box.isChecked()){
                    //Delay to see animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            objects.remove(getItem(position)); //Your object list where you have the itens
                            notifyDataSetChanged(); //If you are using a recycler view.
                        }
                    },300); //adding 0.3 sec delay
                }
            }
        });
return convertView;