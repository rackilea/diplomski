int numberOfLines=0;

for (String line : str.split("\n")) {
    g2d.drawString(line, x , y + (numberOfLines * height));
    numberOfLines++;
}

g2d.drawRect(x - 2, y - height + 2, width + 4, height * numberOfLines);