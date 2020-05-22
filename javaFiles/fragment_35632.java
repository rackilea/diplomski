private static final Color[] BW_VALUES = {Color.BLACK, Color.WHITE};

public static Color convertToBW_1(final Color clr, final double cutoff) {
    /**
     * rd will be 0, if red channel under cutoff, ie black. rd will be 1, if red channel is above cutoff, ie white
     */
    final byte rd = (byte) (Double.doubleToRawLongBits(cutoff - clr.getRed()) >>> 63);
    final byte gd = (byte) (Double.doubleToRawLongBits(cutoff - clr.getGreen()) >>> 63);
    final byte bd = (byte) (Double.doubleToRawLongBits(cutoff - clr.getBlue()) >>> 63);

    /**
     * if at least one value is 1, then return white.
     */
    return BW_VALUES[rd | gd | bd];
}