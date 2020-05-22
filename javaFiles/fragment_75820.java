public static  boolean MONDAY_WAS_RUNNING;
    public static  boolean TUESDAY_WAS_RUNNING;

    ..........


    buttonMon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MONDAY_WAS_RUNNING = true;
            TUESDAY_WAS_RUNNING = false;
            Intent intent = new Intent(FirstActivity.this, MainActivity.class);
            intent.putExtra(BUTTON_KEY1, BUTTON_VALUE);

            startActivity(intent);
        }    });
        buttonTue.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TUESDAY_WAS_RUNNING = true;
            MONDAY_WAS_RUNNING = false;
            Intent i = new Intent(FirstActivity.this, MainActivity.class);
            i.putExtra(BUTTON_KEY2, BUTTON_VALUE2);
            startActivity(i);
        }    });}}