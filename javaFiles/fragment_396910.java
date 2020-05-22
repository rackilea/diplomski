private static final double ONE_DOT_ZERO_SIX = 1.06f;
private static final double ONE_DOT_ZERO_EIGHT = 1.08f;

/**
 * Just to know if it is valid
 */
public boolean setMultiplier(double multiplier) {
    return (multiplier == ONE_DOT_ZERO_SIX || multiplier == ONE_DOT_ZERO_EIGHT
            || multiplier == (ONE_DOT_ZERO_SIX * ONE_DOT_ZERO_EIGHT));
}

/**
 * Return the multiplier if it is valid, otherwise 1
 */
public double setMultiplier(double multiplier) {
    if (multiplier == ONE_DOT_ZERO_SIX || multiplier == ONE_DOT_ZERO_EIGHT
            || multiplier == (ONE_DOT_ZERO_SIX * ONE_DOT_ZERO_EIGHT)) {
        return multiplier;
    } else {
        // return any invalid multiplier, this one doesn't change values at least
        return 1;   
    }
}

/**
 * Set the correct multiplier or a substitute
 */
public void setMultiplier(double multiplier) {
    if (multiplier == ONE_DOT_ZERO_SIX || multiplier == ONE_DOT_ZERO_EIGHT
            || multiplier == (ONE_DOT_ZERO_SIX * ONE_DOT_ZERO_EIGHT)) {
        this.multiplier = multiplier;
    } else {
        // return any invalid multiplier, this one doesn't change values at least
        this.multiplier = 1;
    }
}