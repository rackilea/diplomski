buildMoreButton = (Button) findViewById(R.id.buildMore);
    buildMoreButton.setText("BUILD");
    buildMoreButton.setBackgroundColor(-65536);
    buildMoreButton.setOnTouchListener(new OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent event) 
        {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                buildMoreButton.setBackgroundColor(-1);
            }//end if
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                buildMoreButton.setBackgroundColor(-65536);
            }//end else if



    });//end OnTouchListener

//open dialog for building choices
            buildingSelect = new Dialog(runGraphics.this);
            buildingSelect.setContentView(R.layout.dialog);
            buildingSelect.setTitle("Building Selection");

            exit = (Button) buildingSelect.findViewById(R.id.exit);
            exit.setText("X");
            exit.setBackgroundColor(-65536);
            exit.setOnTouchListener(new OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event) 
                {
                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                    {
                        exit.setBackgroundColor(-1);
                    }//end if
                    else if (event.getAction() == MotionEvent.ACTION_UP)
                    {
                        exit.setBackgroundColor(-65536);
                        buildingSelect.dismiss();
                    }//end else if

                    return false;
                }//end onTouch          
            });//end OnTouchListener

            colonyHut = (ImageView) buildingSelect.findViewById(R.id.colonyHut);

            buildingSelect.show();
            return false;
    }//end onTouch function