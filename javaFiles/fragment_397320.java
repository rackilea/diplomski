ImageView star=(ImageView)findViewById(R.id.favorite);
star.setOnClickListener(new OnClickListener() 
    {
        @Override
        public void onClick(View v) 
        {
            star.setImageResource(android.R.drawable.star_big_on);

        }
    });