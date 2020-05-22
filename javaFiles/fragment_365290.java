final Paint blue = new Paint();
blue.setColor(Color.BLUE);

View progressBar = new View(getActivity()){

        protected void onDraw(android.graphics.Canvas canvas) {

            canvas.drawRect(0,0,getWidth()*progressPecentFirst,getHeight(),blue);
            blue.setColor(Color.RED);
            canvas.drawRect(0,0,getWidth()*progressPecentSecond,getHeight(),blue);
            //Repeat this
        };
    };
parentLayout.addView(progressBar);