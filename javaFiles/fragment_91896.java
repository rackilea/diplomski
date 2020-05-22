/**
 * <p>Converts an Integer to a boolean specifying the conversion values.</p>
 * 
 * <pre>
 *   BooleanUtils.toBoolean(new Integer(0), new Integer(1), new Integer(0)) = false
 *   BooleanUtils.toBoolean(new Integer(1), new Integer(1), new Integer(0)) = true
 *   BooleanUtils.toBoolean(new Integer(2), new Integer(1), new Integer(2)) = false
 *   BooleanUtils.toBoolean(new Integer(2), new Integer(2), new Integer(0)) = true
 *   BooleanUtils.toBoolean(null, null, new Integer(0))                     = true
 * </pre>
 *
 * @param value  the Integer to convert
 * @param trueValue  the value to match for <code>true</code>,
 *  may be <code>null</code>
 * @param falseValue  the value to match for <code>false</code>,
 *  may be <code>null</code>
 * @return <code>true</code> or <code>false</code>
 * @throws IllegalArgumentException if no match
 */
public static boolean toBoolean(Integer value, Integer trueValue, Integer falseValue) {
    if (value == null) {
        if (trueValue == null) {
            return true;
        } else if (falseValue == null) {
            return false;
        }
    } else if (value.equals(trueValue)) {
        return true;
    } else if (value.equals(falseValue)) {
        return false;
    }
    // no match
    throw new IllegalArgumentException("The Integer did not match either specified value");
}