Mat frame = new Frame();
capture.read(frame);
int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
System.out.println("width = " + width );
System.out.println("height = " + height);