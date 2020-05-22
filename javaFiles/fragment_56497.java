public void drawBitmapsInCanvas(Canvas c){
        c.drawBitmap(block, new Rect(/*coordinates here*/), new Rect(/*More coordinates*/),null);
        c.drawBitmap(block2, new Rect(/*coordinates here*/), new Rect(/*More coordinates*/),null);
        c.drawBitmap(laser, new Rect(/*coordinates here*/), new Rect(/*More coordinates*/),null);
        c.drawColor(Color.BLACK);//this hides everything under your black background.
        c.drawBitmap(circle, new Rect(/*coordinates here*/), new Rect(/*More coordinates*/),null);
    }