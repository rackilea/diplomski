public SimpleUrn(int[] ballArray) { // Sets up PolyaUrn by rolling it
    int[] ballCounts = ballArray;

    // last draw is not a meaningful value until a ball is drawn.
    lastDraw = -1;
}