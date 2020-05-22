//I just wrote this here so there might be some errors

static int images[] = new int[] {R.drawable.artistes, R.drawable.couple1, R.drawable.couple2}; //ETC intialize
ImageView view; //initialize
Handler handler; //initialize
int index = 0;
Runnable updater = new Runnable() {
    public void run() {
        if(index == images.length) {
            //animation is done
        }
        else {
            view.setImageResource(images[index++]);
            handler.postDelayed(this, 5000);
        }
    }
};

private void startAnimation() {
    handler.post(updater);
}