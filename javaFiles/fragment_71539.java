private Color createRandomBrightColor() {
    float h = random.nextFloat();
    float s = 1f;
    float b = MIN_BRIGHTNESS + ((1f - MIN_BRIGHTNESS) * random.nextFloat());
    Color c = Color.getHSBColor(h, s, b);
    return c;
}