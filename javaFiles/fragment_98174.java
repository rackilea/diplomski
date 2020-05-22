// Declare a viewport object
private Viewport v;

public GameRenderer() {
    // initialize after your camera initialization
    v = new FitViewport(408, 272, cam); // <- I have use a FitViewport 
                                        //    but you can use others
    // I guess you could remove the setToOrtho() but not too sure...
    // ... rest of code
}