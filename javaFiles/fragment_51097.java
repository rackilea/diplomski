public void drawTriangle(int coordX, int coordY, int sideLen, String fillColor, int strokeWidth, String strokeColor) {
        this.marginSTART = coordX;
        this.marginTOP = coordY;

        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;

        //Съотношение:
        double suotnoshenie = 0.857;

        this.getLayoutParams().width = sideLen;
        this.getLayoutParams().height = (int) Math.floor(sideLen*suotnoshenie);

        this.setX(this.marginSTART);
        this.setY(this.marginTOP);

        //Първи тръигълник, който ще се запълни (реална големина)

        Paint paint = new Paint();
        Bitmap bitmap = Bitmap.createBitmap(sideLen, (int) Math.floor(sideLen*suotnoshenie), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        /*paint.setColor(Color.parseColor("#ff0000")); //testing
        canvas.drawPaint(paint);*/

        paint.setStrokeWidth(0);
        paint.setColor(Color.parseColor(fillColor));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.setLastPoint(0, (float) (sideLen*suotnoshenie)); // A
        path.lineTo(sideLen, (float) (sideLen*suotnoshenie)); // B
        path.lineTo((float)(sideLen/2), 0); // C
        path.lineTo(0, (float) (sideLen*suotnoshenie)); // A
        path.close();

        canvas.drawPath(path, paint);

        //Втори тръигълник, който няма да се запълва, а само ще stroke-ва
        // (линиите, който го очертават трябва да влизат вътре в големия до половината stroke, понеже самият stroke минава от двете страни на линиите...)

        Paint paint2 = new Paint();

        paint2.setStrokeWidth(strokeWidth);
        paint2.setColor(Color.parseColor(strokeColor));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);

        Path path2 = new Path();
        path2.setLastPoint((float) (0+(strokeWidth*1.75)/2), (float) ((sideLen*suotnoshenie)-strokeWidth/2)); // A
        path2.lineTo((float) (sideLen-(strokeWidth*1.75)/2), (float) ((sideLen*suotnoshenie)-strokeWidth/2)); // B
        path2.lineTo((float) (sideLen/2), (float) (0+strokeWidth)); // C
        path2.lineTo((float) (0+(strokeWidth*1.75)/2), (float) ((sideLen*suotnoshenie)-strokeWidth/2)); // A
        path2.close();

        canvas.drawPath(path2, paint2);

        BitmapDrawable bmpDrawable = new BitmapDrawable(getResources(), bitmap);
        this.setBackground(bmpDrawable);
    }