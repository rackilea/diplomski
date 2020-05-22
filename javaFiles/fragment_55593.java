protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            lc = new LineController();
            firstCanvas = new EditingView(this);
            secondCanvas = new EditingView(this);
            firstCanvas.viewIndex(0);
            secondCanvas.viewIndex(1);
            firstCanvas.init(lc);
            secondCanvas.init(lc);
            firstCanvas.setOnTouchListener(new TouchListener());
            secondCanvas.setOnTouchListener(new TouchListener());
            firstFrame = (FrameLayout)findViewById(R.id.firstFrame);
            secondFrame = (FrameLayout)findViewById(R.id.secondFrame);
            firstFrame.addView(firstCanvas);
            secondFrame.addView(secondCanvas);
    }

private class TouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            EditingView temp = (EditingView)v;
            if(drawingMode) {
                // drawing mode
                temp.drawLine(event);
                updateCanvas();
            }else{
                // edit mode
                temp.editLine(event);
                updateCanvas();
            }
            return true;
        }
    }