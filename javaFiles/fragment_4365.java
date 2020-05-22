Graphics g = image.getGraphics();
g.setFont(g.getFont().deriveFont(30f));
int lineHeight = g.getFontMetrics().getHeight();
//here comes the iteration over all lines
for(int lineCount = 0; lineCount < lines.length; lineCount ++){ //lines from above
    int xPos = 100;
    int yPos = 100 + lineCount * lineHeight;
    String line = lines[lineCount];
    g.drawString(line, xpos, yPos);
}
g.dispose();