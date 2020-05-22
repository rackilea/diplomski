double answer = arrayList.get(0);
    double current = Double.MAX_VALUE;
    for (Double value : arrayList) {
        if (Math.abs(value - x) < current) {
            answer = value;
            current = Math.abs(value - x);
        }
    }