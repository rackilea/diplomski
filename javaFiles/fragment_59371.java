ImageButton goto_location = new ImageButton(this);
    goto_location.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            showMylocation();
        }           
    });

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(40, 40);
    params.rightMargin = 10;
    params.topMargin = 10;
    rl.addView(goto_location, params);