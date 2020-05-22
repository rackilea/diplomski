ImageButton button1,button2,button3,button4;
            ImageButton imagebuttons[]={ button1,button2,button3,button4};
        int ids[]={R.id.imageButton1,R.id.imageButton2,R.id.imageButton3,R.id.imageButton4};

        for(final int i=0;i<imagebuttons.length;i++)
        {
            imagebuttons[i]=(ImageButton) findViewById(ids[i]);
    int index=rand.nextInt(arraySize);
             imagebuttons[i].setImageResource(flags[index]);
             flags[index] = flags[--arraySize];
             indexes.put(i,index);
            imagebuttons[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if( questionArray==indexes.get(i))
                    {

                    }

                }
            });