ImageButton facebookButton = (ImageButton)findViewById(R.id.facebook1);
  facebookButton.setOnClickListener(new View.onClickListener() 
   {  
        public void onClick(View arg0) 
          { 
               Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/apple.fruit"));
                startActivity(browserIntent);

               }
         });