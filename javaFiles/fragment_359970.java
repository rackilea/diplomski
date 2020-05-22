ImageButton[] hand = new ImageButton[12];
int[] pressed_index = new int[3];
int counter = 0;
for (int[] x = new int[]{0}; x[0] < 12; x[0]++) {
    hand[x[0]] = (ImageButton)findViewById(R.id.//card_1, card_2, etc.);
    hand[x[0]].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
                pressed_index[counter] = x[0];
                counter++;
                if (counter != 3) {
                    ((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
                }
        }
    });
}