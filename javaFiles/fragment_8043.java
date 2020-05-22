private static void generateBMPwithDistribution(int[] shadesOfGray, int sum, String path) throws IOException {

    int dim1 = (int)Math.sqrt(shadesOfGray.length), dim=100*dim1;
    int[] buffer = new int[dim * dim];    

    int howManyTimes=dim/dim1;
    for (int x = 0; x < dim; x++)        
        for (int y = 0; y < dim; y++) {                                             
            int valueToReplicate=shadesOfGray[(x + y*dim)/howManyTimes];
            buffer[x + y*dim] = 0xff000000|(valueToReplicate<<16)|(valueToReplicate<<8)|valueToReplicate;
        }

    BufferedImage result=new BufferedImage(dim, dim, BufferedImage.TYPE_INT_RGB);

    try {
        ImageIO.write(result, "bmp", new File(path));
    } catch (IOException e) {
        ...
    }

}