Line2D line1 = new Line2D.Float(100, 100, 200, 200);
Line2D line2 = new Line2D.Float(150, 150, 150, 200);
boolean result = line2.intersectsLine(line1);
System.out.println(result); // => true

// Also check out linesIntersect() if you do not need to construct the line objects
// It will probably be faster due to putting less pressure on the garbage collector
// if running it in a loop
System.out.println(Line2D.linesIntersect(100,100,200,200,150,150,150,200));