    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        LayoutInflater inflater = (LayoutInflater)this.getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View sampleActionView = inflater.inflate(R.layout.sample_action_view, null);
        MenuItem searchMenuItem = menu.findItem(R.id.menu_myDemoToolbarButton);
        serachMenuItem.setActionView(sampleActionView);

        sampleActionView.setOnTouchListener(new OnTouchListener() 
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                // TODO Auto-generated method stub
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);