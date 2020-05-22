public enum MatrixPosition {
    WALL(1), CORRIDOR(0), END(2);

    private int value;

    private MatrixPosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MatrixPosition getMatrixPosition(int value) {
        for (MatrixPosition position : MatrixPosition.values()) {
            if (value == position.getValue()) {
                return position;
            }
        }
        String text = "value of " + value;
        throw new IllegalArgumentException(text);
    }

    public static MatrixPosition getMatrixPosition(String strValue) {
        int value = -1;
        try {
            value = Integer.parseInt(strValue);
        } catch (NumberFormatException e) {
            String text = "NumberFormatException for strValue " + strValue;
            throw new IllegalAccessError(text);
        }
        return getMatrixPosition(value);
    }
}