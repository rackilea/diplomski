final List<Button> mButtons = new ArrayList<>();


void onCreate(){

    for ( int i = 0 ; i< BUTTON_COUNT; i++){

         final Button btn = new Button(mContext);
         btn.setOnClickListener(new OnClickListener(){

              void onClick(View view){
                   int position = mButtons.indexOf(btn); 
                   //since you know the button position, do whatever you want with it.
              }

         });
      }

}