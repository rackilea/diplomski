protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        int rectWidth = w / 5;
        int space = w / 15;
        int topRectHeight = getPaddingTop();
        int bottomRectHeight = getPaddingBottom();

        paint.setStyle(Paint.Style.STROKE); //add this
        for (int i = 0; i < 4; i++) {
            int left = i * (rectWidth + space);
            int right = left + rectWidth;

            if (i == 1){ 
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.BLACK);
                Rect rect = new Rect(left, 0, right, topRectHeight);
                canvas.drawRect(rect, paint);
                //again set back the style here
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.RED);
                Rect rect2 = new Rect(left, 0, right, topRectHeight);
                canvas.drawRect(rect2, paint);
                //this will draw the lower rectangle! Using extra variable rect3 just for safer side.
                Rect rect3 = new Rect(left, h - bottomRectHeight, right, h);
                canvas.drawRect(rect3, paint);
            }else{
                Rect rect = new Rect(left, 0, right, topRectHeight);
                canvas.drawRect(rect, paint);
                paint.setStyle(Paint.Style.STROKE);//add this
                Rect rect2 = new Rect(left, h - bottomRectHeight, right, h);
                canvas.drawRect(rect2, paint);
            }
        }
    }