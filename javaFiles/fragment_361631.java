static class ColorChanger {
    static private final int    APPROACH_STEPS  = 10;

    private final Color         mStartColor;
    private final Color         mTargetColor;

    private int                 mApproachStep   = 0;
    private Color               mCurrentColor;

    public ColorChanger(final Color pStartColor, final Color pTargetColor) {
        mStartColor = pStartColor;
        mTargetColor = pTargetColor;
        System.out.println("\nStarting color is: " + mStartColor);
        System.out.println("Approaching target 1: " + mTargetColor);
    }

    public Color approach() {
        ++mApproachStep;
        if (mApproachStep <= APPROACH_STEPS) { // dont overshoot target color. could throw an exception here too
            final int newRedCode = nextColorCode(mStartColor.getRed(), mTargetColor.getRed());
            final int newGreenCode = nextColorCode(mStartColor.getGreen(), mTargetColor.getGreen());
            final int newBlueCode = nextColorCode(mStartColor.getBlue(), mTargetColor.getBlue());
            mCurrentColor = new Color(newRedCode, newGreenCode, newBlueCode);
        }
        System.out.println("\tNew step color is: " + mCurrentColor);
        return mCurrentColor;
    }

    private int nextColorCode(final int pCurrentCode, final int pTargetCode) {
        final int diff = pTargetCode - pCurrentCode;
        final int newCode = pCurrentCode + diff * mApproachStep / APPROACH_STEPS;
        return newCode;
    }

    public Color getCurrentColor() {
        return mCurrentColor;
    }

    public boolean isTargetColor() {
        return mApproachStep == APPROACH_STEPS;
    }
}

public static void main(final String[] args) {
    final Color startColor = Color.RED;
    final Color targetColor1 = Color.GREEN;
    final Color targetColor2 = Color.BLUE;
    final Color targetColor3 = Color.RED;

    // approach in only 5 steps, will by far not reach target color
    final ColorChanger cc1 = new ColorChanger(startColor, targetColor1);
    for (int i = 0; i < 5; i++) {
        cc1.approach();
    }

    // full approach #1
    final ColorChanger cc2 = new ColorChanger(cc1.getCurrentColor(), targetColor2);
    while (!cc2.isTargetColor()) {
        cc2.approach();
    }

    // full approach #2
    final ColorChanger cc3 = new ColorChanger(cc2.getCurrentColor(), targetColor3);
    for (int i = 0; i < ColorChanger.APPROACH_STEPS; i++) {
        cc3.approach();
    }

    System.out.println("Program ends");
}