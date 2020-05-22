class MatTest {
    static void makeSums(float[][] floats) {
        // we wouldn't be doing any operations on these inputs anyway, so return
        if(floats == null || floats.length == 0 || floats.length == 1) return;

        // check to make sure it's retangular
        for(float[] arr : floats) {
            if(arr.length != floats[0].length) {
                throw new IllegalArgumentException("makeSums() requires rectangular array");
            }
        }

        for(int i = 0; i < floats[0].length; i++) {
            // do each column
            float sum = 0f;
            for(int j = 0; j < floats.length; j++) {
                sum += floats[j][i];
            }
            for(int j = 0; j < floats.length; j++) {
                if(floats[j][i] != 0) floats[j][i] = sum;
            }
        }
    }

    public static void main(String[] args) {
        float[][] floats = new float[3][5];
        floats[0] = new float[] {0.2f,0.0f,0.3f,0.0f,0.0f};
        floats[1] = new float[] {0.4f,0.1f,0.0f,0.0f,0.9f};
        floats[2] = new float[] {0.0f,0.0f,0.0f,0.3f,0.6f};

        makeSums(floats);

        for(int i = 0; i < floats.length; i++) {
            for(int j = 0; j < floats[0].length; j++) {
                System.out.print(floats[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}