private void nextCycle() {
    int axis1 = random.nextInt(2);
    int axis2 = 1 - axis1;
    directionOne = AXES[axis1][random.nextInt(2)];
    directionTwo = AXES[axis2][random.nextInt(2)];
    count = 0;        
}