@Override
    public void onClick(View v) {
        Clicks++;
        switch (Clicks)
        {
            case 1:
                aButton4.setImageResource(R.drawable.reg0);
                toggleSound.start();
                sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("clicked4", count);
                editor.commit();
            case 2:
                aButton4.setImageResource(R.drawable.reg1);
                toggleSound.start();
                sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("clicked4", count);
                editor.commit();
            case 3:
                ....
            case 4:
                ....
                Clicks =0;
       }