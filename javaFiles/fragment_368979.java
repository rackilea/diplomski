private static int getTimeForSide(int side) {    
    Integer timeVal = SIDE2TIMEMap.get(Integer.valueOf(side));
    if (timeVal == null) {
        timeVal = Integer.valueOf(1000); // default value
        // alternatively: throw new IllegalArgumentException("invalid side: " + side);
    }
    return timeVal.intValue();
}

[...]

    int side1time = getTimeForSide(side1);
    int side2time = getTimeForSide(side2);