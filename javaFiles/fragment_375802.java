public void clickEcra() {
    setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:

                case MotionEvent.ACTION_UP:

                    CursorX = (int)event.getX();
                    CursorY = (int)event.getY();

                    if (figure == 2){
                        Ponto2D ptReta = new Ponto2D();
                        ptReta.x = CursorX;
                        ptReta.y = CursorY;
                        ptsReta.add(ptReta);
                        invalidate();
                    }

                default:
                    return false;
            }
        }
    });
}