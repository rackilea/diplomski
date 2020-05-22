public static double[] list() {
    anArray = new double[10];
    for(int i=0;i<anArray.length;i++)
    {
        anArray[i] = randomFill();
    }
    return anArray;
}