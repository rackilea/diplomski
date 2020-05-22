public Window() {
    Canvas canvas = new Canvas(512, 512);
    gc = canvas.getGraphicsContext2D();
    setCenter(canvas);
    gc.setFill(Color.BLACK);
    Anim a = new Anim();
    a.start();
}