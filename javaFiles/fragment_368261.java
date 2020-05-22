int currentColor;
private Runnable changeColorRunnable = new Runnable() {

    @Override
    public void run() {
        switch(currentColor){
        case Color.RED: currentColor = Color.BLACK; break;
        case Color.BLACK: currentColor = Color.RED; break;
        }
        button.setBackgroundColor(currentColor);

    }
};