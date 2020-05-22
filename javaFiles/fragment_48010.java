AnimationTimer timer = new AnimationTimer() {    

    @Override
    public void handle(long now) {
        x.set(String.valueOf(randomizedX()));
        y.set(String.valueOf(randomizedY()));
        z.set(String.valueOf(randomizedZ()));
    }
};