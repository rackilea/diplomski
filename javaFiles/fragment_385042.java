int left = 50; // initial start position of rectangles (50 pixels from left)
int top = 50; // 50 pixels from the top
int width = 150;
int height = 150;
for (int row = 0; row < 2; row++) { // draw 2 rows
    for(int col = 0; col < 4; col++) { // draw 4 columns
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawRect(left, top, left+width, top+height, paint);
        left = (left + width + 10); // set new left co-ordinate + 10 pixel gap
        // Do other things here
        // i.e. change colour
    }
    top = top + height + 10; // move to new row by changing the top co-ordinate
}