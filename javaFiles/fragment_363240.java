public class Forward {
    private final RegulatedMotor left;
    private final RegulatedMotor right;

    public Forward(RegulatedMotor left, RegulatedMotor right) {
        this.left = left;
        this.right = right;
    }

    public void moveForward() { ... }
}