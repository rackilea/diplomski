Table data;
PShape dataPlot;

size(1620, 1080,P2D);
//create a group to store the lines from each row
dataPlot = createShape();
//load the data, specifying it has a header and it's tab separated
data = loadTable("data.tsv", "header, tsv");
//traverse each row
dataPlot.beginShape(LINES);
for(TableRow row : data.rows()){
  //extract each value
  int x1 = row.getInt("x1");
  int y1 = row.getInt("y1");
  int x2 = row.getInt("x2");
  int y2 = row.getInt("y2");
  //add the coordinates as lines to the group
  dataPlot.stroke(160);
  dataPlot.vertex(x1,y1);
  dataPlot.stroke(0);
  dataPlot.vertex(x2,y2);
}
dataPlot.endShape();
//render the plot
shape(dataPlot);