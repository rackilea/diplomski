// Create the SpriteGraphics2D object
     SpriteGraphics2D g = new SpriteGraphics2D(100, 100);

     // Draw on to the graphics object
     Font font = new Font("Serif", Font.PLAIN, 16);
     g.setFont(font);         
     g.drawString("Test swf", 30, 30);         
     g.draw(new Line2D.Double(5, 5, 50, 60));
     g.draw(new Line2D.Double(50, 60, 150, 40));
     g.draw(new Line2D.Double(150, 40, 160, 10));

     // Create a new empty movie
     Movie m = new Movie();
     m.version = 7;
     m.bgcolor = new SetBackgroundColor(SwfUtils.colorToInt(255, 255, 255));
     m.framerate = 12;
     m.frames = new ArrayList(1);
     m.frames.add(new Frame());
     m.size = new Rect(11000, 8000);

     // Get the DefineSprite from the graphics object
     DefineSprite tag = g.defineSprite("swf-test");

     // Place the DefineSprite on the first frame
     Frame frame1 = (Frame) m.frames.get(0);
     Matrix mt = new Matrix(0, 0);
     frame1.controlTags.add(new PlaceObject(mt, tag, 1, null));

     TagEncoder tagEncoder = new TagEncoder();
     MovieEncoder movieEncoder = new MovieEncoder(tagEncoder);
     movieEncoder.export(m);

     //Write to file
     FileOutputStream fos = new FileOutputStream(new File("/test.swf"));
     tagEncoder.writeTo(fos);