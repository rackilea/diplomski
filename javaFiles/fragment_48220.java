public VectorND resVec(int n)
{
    int[] coordinates = new int[n];
    Arrays.fill(coordinates, 0);

    VectorND resVec = new VectorND(coordinates);       
    return resVec;
}