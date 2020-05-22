private boolean compare(String property, String operator, String operand) {
    int pv = Integer.parseInt(property);
    int ov = Integer.parseInt(operand);
    if (operator.equals("<")) {
        return pv < ov;
    } else if (operator.equals("<=")) {
        return pv <= ov;
    } else if (operator.equals(">")) {
        return pv > ov;
    } else if (operator.equals(">=")) {
        return pv >= ov;
    } else if (operator.equals("!=")) {
        return pv != ov;
    } else if (operator.equals("=") || operator.equals("==")) {
        return pv == ov;
    }
    return false;
}