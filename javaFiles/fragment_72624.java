Color complementaryColor(final Color bgColor) {

    Color complement = new Color(255 - bgColor.getRed(),
            255 - bgColor.getGreen(),
            255 - bgColor.getBlue());

    return complement;
}