void setTextFit(JLabel label, String text) {
    Font originalFont = (Font)label.getClientProperty("originalfont"); // Get the original Font from client properties
    if (originalFont == null) { // First time we call it: add it
        originalFont = label.getFont();
        label.putClientProperty("originalfont", originalFont);
    }

    int stringWidth = label.getFontMetrics(originalFont).stringWidth(text);
    int componentWidth = label.getWidth();

    if (stringWidth > componentWidth) { // Resize only if needed
        // Find out how much the font can shrink in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)Math.floor(originalFont.getSize() * widthRatio); // Keep the minimum size

        // Set the label's font size to the newly determined size.
        label.setFont(new Font(originalFont.getName(), originalFont.getStyle(), newFontSize));
    } else
        label.setFont(originalFont); // Text fits, do not change font size

    label.setText(text);
}