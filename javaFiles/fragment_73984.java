// This needs to happen in the down press on the canvas
if(currentBrush == Brush.SPRAY_CAN){
    int dotsToDrawAtATime = 20;
    double brushRadius = 1.0; // This is however large they set the brush size, could be (1), could be whatever the max size of your brush is, e.g., (50), but set it based on what they choose

    for (int i = 0; i < dotsToDrawAtATime; i++){
        // Pick a random color for single dot to draw
        ...

        // Get the location to draw to
        int x = touchedX + Random.nextGaussian()*brushRadius;
        int y = touchedY + Random.nextGaussian()*brushRadius;

        // Draw the point, using the random color, and the X/Y value
        ...
    }
}