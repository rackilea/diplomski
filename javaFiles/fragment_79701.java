public void redrawCanvas (Canvas canvas) {
        GC gc = new GC(canvas);
        gc.setClipping(90,90,60,60);
        gc.drawRectangle(90,90,30,30);
        gc.dispose();
    }