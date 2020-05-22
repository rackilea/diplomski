ImageButton[] hand = new ImageButton[12];
int[] pressed_index = new int[3];
int counter = 0;
for (int x = 0; x < 12; x++) {
    final int x_ = x;
    hand[x] = (ImageButton)findViewById(R.id.//card_1, card_2, etc.);
    hand[x].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
             pressed_index[counter] = x_;
             counter++;
             if (counter != 3) {
                 ((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
             }
        }
    });
}