FontMetrics fm = button.getFontMetrics(button.getFont());
int width = fm.stringWidth("MMM");
int height = fm.getHeight();
Insets insets = button.getInsets();
Insets margins = button.getMargin();
width += insets.left + insets.right + margins.left + margins.right;
height += insets.top + insets.bottom + margins.top + margins.bottom;
button.setPreferrdSize(new Dimension(width, height));