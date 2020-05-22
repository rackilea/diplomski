ImageView image = (ImageView)findViewById(R.id.img);

        CurvedBitmapDrawer drawer = new CurvedBitmapDrawer(this);

        Paint paint = new Paint();

        paint.setStrokeWidth(50);

        drawer.setPaint(paint);
        drawer.setResourceId(R.drawable.heart_icon);
        drawer.setBitmapMargin(10);

        Path path = drawer.getPath();

        path.moveTo(80, 90);
        path.cubicTo(160, 470, 750, 290, 440, 880);

        Bitmap finalBitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(finalBitmap);

        drawer.draw(canvas);

        image.setImageBitmap(finalBitmap);