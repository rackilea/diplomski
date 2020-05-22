Segment seg1 = new Segment(2.0, 3.5);
Segment seg2 = new Segment(1.4, 4.2);

Path example1 = new Path();            // no segments
Path example2 = new Path(seg1);
Path example3 = new Path(seg1, seg2);  // etc.