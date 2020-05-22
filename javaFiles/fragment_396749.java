canvas.addShape (new Shape () {
        @Override
        public void draw(Canvas c) {
            Paint p = new Paint ();
            p.setColor (Color.BLACK);
            p.setStrokeWidth (5);
            c.drawLine (100, 100, 500, 100, p);
        }
    });