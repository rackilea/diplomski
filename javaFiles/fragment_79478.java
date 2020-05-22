ImageView imageView = (ImageView)findViewById(R.id.theImage);

Button myBtn = (Button)findViewById(R.id.myButton);
myBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
               RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)imageView.getLayoutParams();
               params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
               params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
               imageView.setLayoutParams(params); 
          }
      });