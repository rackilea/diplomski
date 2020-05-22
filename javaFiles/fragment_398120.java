webView.setOnTouchListener(new SwipeListener(this)
    {
        @Override
        public void onSwipeLeft()
        {
            articleID--;
            //System.out.println("SWIPE_LEFT");
            Intent myIntent = new Intent(ShowActivity.this, ShowActivity.class);
            myIntent.putExtra("id", articleID);
            System.out.println(myIntent.toString());
            ShowActivity.this.startActivity(myIntent);
        }
        @Override
        public void onSwipeRight()
        {
            articleID++;
            //System.out.println("SWIPE_RIGHT");
            Intent myIntent = new Intent(ShowActivity.this, ShowActivity.class);
            myIntent.putExtra("id", articleID);
            System.out.println(myIntent.toString());
            Swiped = true;
            ShowActivity.this.startActivity(myIntent);
        }
    });