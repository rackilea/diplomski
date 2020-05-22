// Let's say you define an imageview in your layout xml file. Find it in code:
imageView1 = (ImageView) findViewById(....);

// Now you add your camera view.
.........

// Once you add your camera view to the framelayout, the imageview will be 
// behind the frame. Do the following:
framelayout.removeView(imageView1);
framelayout.addView(imageView1);

// That's it. imageView1 will be on top of the camera view, positioned the way
// you defined in xml file