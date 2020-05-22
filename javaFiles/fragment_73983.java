// This needs to happen in the down press on the canvas
if(currentBrush == Brush.SPRAY_CAN){
    int dotsToDrawAtATime = 20;
    double brushRadius = 1.0; // This is however large they set the brush size, could be (1), could be whatever the max size of your brush is, e.g., (50), but set it based on what they choose

    for (int i = 0; i < dotsToDrawAtATime; i++){
        // Pick a random color for single dot to draw
        // Get the circumference of the circle (2*pi*brushRadius), based on the X/Y that the user input when they pressed down. Pick a random spot inside that area, and draw a single dot. As this is a for loop, it will happen 20 different times for this one occurrence.
    }
}