public class World {
    public String[][][][][] fiveDim = new String[10][10][10][10][10];

public void world(int dim1, int dim2, int dim3, int dim4, int dim5, String color)
{
    fiveDim[dim1][dim2][dim3][dim4][dim5] = color;
}
}