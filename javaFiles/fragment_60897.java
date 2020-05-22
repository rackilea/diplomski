double maxY = 0;
for (int i = 0; i < xAxis; i++) {
    maxY = Math.max(maxY, Math.abs(getValue(i)));
}

for (int i = 0; i < xAxis; i++) {
    x = xBase + i;
    y = yBase - (int) (getValue(i) / maxY * yScale);
    g.drawLine(x,y,x,y);
}