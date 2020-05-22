View.OnTouchListener touchListener = new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            ultimoToque[0] = event.getX();
            ultimoToque[1] = event.getY();
        }

        double x = ultimoToque[0];
        double y = ultimoToque[1];
        addNewImage(x, y)
        Log.i("TAG", "Novas coordenadas x: " + x + ", y: " + y);

        return false;
    }
};