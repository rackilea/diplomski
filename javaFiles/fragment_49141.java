public class MyFloatKMeansInit extends FloatKMeansInit{
    private float [][] mycentroids;

    public MyFloatKMeansInit(float [][] mycentroids) {//modifying data type here
        this.mycentroids = mycentroids;
    }

    @Override
    public void initKMeans(DataSource<float[]> bds, float[][] clusters) throws IOException {
        for (int i = 0; i < mycentroids.length; i++) {
            for (int j = 0; j < mycentroids[i].length; j++) {
                clusters[i][j]=mycentroids[i][j]; //could use arraycopy instead
            }
        }   
    }
}

public class MyKMColourSegmenter extends KMColourSegmenter{

    public MyKMColourSegmenter(ColourSpace colourSpace, float[][] mycentroids) throws IOException {
        super(colourSpace, mycentroids.length);
        MyFloatKMeansInit myFloatKMeansInit = new MyFloatKMeansInit(mycentroids);
        this.kmeans.setInit(myFloatKMeansInit);
    }

}