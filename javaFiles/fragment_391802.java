public class Die {
    // omitted existing fields
    private boolean locked = false;

    void roll() {
        if (!locked) {
            face = (int)(Math.random() * 6 + 1);
        }
    }
    // omitted existing getter and setter

    public void setLocked(final boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() { // this getter is maybe not necessary
        return locked;
    }
}