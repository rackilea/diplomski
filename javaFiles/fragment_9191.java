String[] parts = input.split("#");
    float[] numbers = new float[parts.length];
    for (int i = 0; i < parts.length; ++i) {
        float number = Float.parseFloat(parts[i]);
        float rounded = (int) Math.round(number * 1000) / 1000f;
        numbers[i] = rounded;
    }