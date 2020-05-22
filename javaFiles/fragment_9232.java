// Draw the graph
for(int week = 1; week <= weeksToSim; week++) {
    int x = getChartX(week);
    g.drawLine(x, getChartY(0), x, 0);
    g.drawString("Week " + week, x-20, getChartY(0) + 20);
}
for(int y=0; y<10; y++) {
    int count = 10 * y;
    int y = getChartY(count);
    g.drawLine(getChartX(1),  y, width, y);
    g.drawString(count + " alive", getChartX(1) - 45, y);
}
// Draw the line
for(int i=0; i<(animalAmt.length-1); i++) {
    int week = i + 1;
    // predator animal line
    g.setColor(Color.red);
    g.drawLine(getChartX(week), getChartY(predatorAnimalAmt[i]), getChartX(week + 1), getChartY(predatorAnimalAmt[i + 1]));
    ...
}