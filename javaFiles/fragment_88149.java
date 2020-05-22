Table data;
PShape dataPlot;

size(1620, 1080, P2D);
//create a group to store the lines from each row
dataPlot = createShape(GROUP);
//load the data, specifying it has a header and it's tab separated
data = loadTable("data.tsv", "header, tsv");
//traverse each row
for (TableRow row : data.rows ()) {
  //extract each value
  int x1 = row.getInt("x1");
  int y1 = row.getInt("y1");
  int x2 = row.getInt("x2");
  int y2 = row.getInt("y2");
  //add the coordinates as lines to the group
  PShape line = createShape(LINE, x1, y1, x2, y2);
  float dist = dist(x1, y1, x2, y2);
  line.setStroke(color(map(dist, 0, height, 160, 0)));
  line.setStrokeWeight(map(dist, 0, height, 10.0, 1.0));
  dataPlot.addChild(line);
}
//render the plot
shape(dataPlot);