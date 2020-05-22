private int[] myInt;
private Rect[] myRect;
private Paint[] myPaint;

public DrawGrid(Context context, int[] binary) {
    myInt = binary;
    myRect = new Rect[myInt.length];
    myPaint = new Paint[myInt.length];

    for (int i = 0; i < myInt.length; i++) {
        //Put Rect parameters here, you have to take advantage of the "i" variable 
        myRect[i] = new Rect();

        myPaint[i] = new Paint();
        myPaint[i].setColor(myInt[i]);
        myPaint[i].setStyle(Paint.Style.FILL);
    }
}

protected void onDraw(Canvas canvas) {
    for (int i = 0; i < myRect.length; i++) { // < not >
        canvas.drawRect(myRect[i], myPaint[i]);
    }
}