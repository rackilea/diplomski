@Override
public void onDraw(Canvas canvas) {
    //This saves off the matrix that the canvas applies to draws, so it can be restored later. 
    canvas.save(); 

    //now we change the matrix
    //We need to rotate around the center of our text
    //Otherwise it rotates around the origin, and that's bad. 
    float py = this.getHeight()/2.0f;
    float px = this.getWidth()/2.0f;
    canvas.rotate(180, px, py); 

    //draw the text with the matrix applied. 
    super.onDraw(canvas); 

    //restore the old matrix. 
    canvas.restore(); 
}