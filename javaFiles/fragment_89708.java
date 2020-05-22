//layout of the composite doesn't work
//composite.layout(true, true);

//layout of parent works
composite.getParent().layout(true, true);

//marks the composite's screen are as invalidates, which will force a 
composite.redraw(); redraw on next paint request 

//tells the application to do all outstanding paint requests immediately
composite.update();