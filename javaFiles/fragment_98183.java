String[] colorNames = { "aquamarine", "Aquamarine", "AntiqueWhite" };
    // List with color as hex, with alpha component as FF
    for (String colorName : colorNames) {
        Color color = Color.valueOf(colorName);
        System.out.printf("%s -> %s%n", colorName, color);
    }