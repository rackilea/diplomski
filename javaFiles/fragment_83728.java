class TestNativeArray3D
{
    public static void main(String args[])
    {
        System.loadLibrary("TestNativeArray3D");
        int terrain[][][] = genTerrain(123, 8, 6);
    }
    private native static int[][][] genTerrain(int seed, int x, int y);
}