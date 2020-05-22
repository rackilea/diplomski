aButton4 = (ImageButton) findViewById(R.id.imageButton4);
SharedPreferences sharedPreferences = getSharedPreferences("NAME", Context.MODE_PRIVATE);
int f = sharedPreferences.getInt("count_key", count);
if (f== 0) {
        aButton4.setImageResource(R.drawable.reg0);
    }
    if (f== 1) {
        aButton4.setImageResource(R.drawable.reg1);
    }
    if (f== 2) {
        aButton4.setImageResource(R.drawable.reg2);
    }
    if (f== 3) {
        aButton4.setImageResource(R.drawable.reg3);
    }
    if (f== 4) {
        aButton4.setImageResource(R.drawable.reg4);
    }