public void updateBG() {

idx += 1;
if (idx == NUM_RES) {idx = 0;}
switch (bgcycle) {
    case 0: myBg = BitmapFactory.decodeResource(getResources(),R.drawable.frame1); break;
    case 1: myBg = BitmapFactory.decodeResource(getResources(),R.drawable.frame2); break;
    case 2: myBg = BitmapFactory.decodeResource(getResources(),R.drawable.frame3); break;
            case etc....
        }}