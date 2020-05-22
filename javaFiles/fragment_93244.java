void setup() {
  // do this every 4 seconds as it is refreshed. We don't want to spam 
  // the website... This method changes how many times should draw() be
  // executed per second. The default value is 24 frames per second. Here
  // we set it to .25 which essentially means 1 draw() every 4 seconds...
  frameRate(0.25);
}
void draw() { 
  // set the background to a boring gray colour...
  background(204); 
  // set the website url. Don't forget the "http://"
  String url = "http://avail.mdx.ac.uk:8090/avail.js?"; 
  // get an array of big strings from the website, one element per line
  // as it is in the page there is actually only one line...
  String [] site = loadStrings(url); 
  // break the first line (site[0]) into an array of strings where
  // there is a ";" and store the array into the 'list' variable
  // Each element looks like this: "HESLGFOA01:84:32"
  String [] list = split(site[0], ';'); 
  // break the first element of list (list[0]) where there are ":" and 
  // store the result into the 'elm' variable
  String [] elm = list[0].split(":"); 
  // ID if the first element in the elm array (elm[0]): HESLGFOA01
  String ID = elm[0]; 
  // total is the second element in the elm array (elm[1]): 84
  int total = int(elm[1]); 
  // used is the third element in the elm array (elm[2]) 32
  int used = int(elm[2]); 
  // calculate the free desks by subtracting the used from the total
  int free = total - used;
  // print stuff / draw ellipses / do fun stuff
  println("Total: " + total + " Used:" + used + " Free: " + free); 
  float x1 = map(mouseX, 0, width, 50, 150); 
  ellipse(x1, 75, 50, 50); 
  float x2 = map(free, 0, width, 0, 200); 
  ellipse(x2, 125, 50, 50);
}