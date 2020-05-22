public static float signum(float f) {
    return (f == 0.0f || isNaN(f)) ? f : copySign(1.0f, f);
}

public static boolean isNaN(float f) {
    return (f != f);
}

public static float copySign(float magnitude, float sign) {
    return rawCopySign(magnitude, (isNaN(sign) ? 1.0f : sign));
}

public static float rawCopySign(float magnitude, float sign) {
    return Float.intBitsToFloat((Float.floatToRawIntBits(sign)
            & (FloatConsts.SIGN_BIT_MASK))
            | (Float.floatToRawIntBits(magnitude)
            & (FloatConsts.EXP_BIT_MASK
            | FloatConsts.SIGNIF_BIT_MASK)));
}

static class FloatConsts {
    public static final int SIGN_BIT_MASK = -2147483648;
    public static final int EXP_BIT_MASK = 2139095040;
    public static final int SIGNIF_BIT_MASK = 8388607;
}