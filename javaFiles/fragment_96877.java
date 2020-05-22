double doubleValue = (px - cx) * (px - cx) + (py - cy) * (py - cy);

    double posDouble = (doubleValue >= 0) ? doubleValue : (doubleValue * -1);

    if (posDouble != 0 && (posDouble < Float.MIN_VALUE || posDouble > Float.MAX_VALUE)) {
        throw new Exception("Overflow");
    }

    return (float)doubleValue;