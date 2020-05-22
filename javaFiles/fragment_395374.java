public static Color fromString(String rgb, Color deflt) {
    String[] comp = rgb.split(",");
    if (comp.length != 3)
        return deflt;
    int rc[] = new int[3];
    for (int i = 0; i < 3; ++i) {
        rc[i] = Integer.parseInt(comp[i].trim());
        if (rc[i] < 0 || rc[i] > 255)
            return deflt;
    }
    Color c = new Color(rc[0], rc[1], rc[2]);
    return c;
}