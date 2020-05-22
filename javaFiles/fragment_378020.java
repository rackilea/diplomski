class Remote  {
    private Remotable target;

    public Remote(Remotable target) {
        this.target = target;
    }

    public void turnOn() {
        target.turnOn();
    }
}