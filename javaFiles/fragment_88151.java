Table data;
PShape plot;

void setup(){
  size(1620, 1080, P2D);
  //create a group to store the lines from each row
  plot = createShape(GROUP);
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
    plot.addChild(line);
  }
  //clear the background
  noStroke();
  shape(plot);//this needs to be drawn at least once it seems
  background(255);
}
void draw(){
  //hacky fade effect, change the alpha (16) transparency value to experiment with fade amount 
  fill(255,16);
  rect(0,0,width,height);
  //animate the trajectories
  //use normalized (between 0.0 and 1.0) value to traverse the paths (think of it as 0 and 100%, 0 is at the start 100% is at the end)
  //if can be interactive
  float traversal;
  if(mousePressed) {
    traversal = map(mouseX,0,width,0.0,1.0);
  }else{//or time based, up to you :)
    traversal = map(sin(frameCount * 0.01),-1.0,1.0,0.0,1.0);
  } 
  //for each trajectory
  for(int i = 0 ; i < plot.getChildCount(); i++){
    PShape line = plot.getChild(i);
    //access each line's start and end points
    PVector start = line.getVertex(0);
    PVector end   = line.getVertex(1);
    //calculate the linearly interpolated point in between start end using the traversal value and lerp()
    PVector inbetween = PVector.lerp(start,end,traversal);
    //use the interpolated value to draw
    fill(lerpColor(color(255,0,0),color(0,255,0),traversal));
    ellipse(inbetween.x,inbetween.y,15,15);
  }
}