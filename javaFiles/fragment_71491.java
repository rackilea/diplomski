int LIGHT_DURATION = 1000;

for (int i = 0; i < mGame.getLevel(); i++) {
    int color = colors.get(i);
    int delay = LIGHT_DURATION*i;
    setBtnBackGround(newColors[color], 10, mButtons[color]);
    if (color == 0) {
        handler.postDelayed(g, delay);
    } else if (color == 1) {
        handler.postDelayed(r, delay);
    } else if (color == 2) {
        handler.postDelayed(b, delay);
    } else {
        handler.postDelayed(y, delay);   
    }
}