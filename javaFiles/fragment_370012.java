public static void saveToFile(BufferedImage img)
    throws FileNotFoundException, IOException
    {

        File outputfile = new File("D:\\Sample.png");
    ImageIO.write(img, "png", outputfile);
    }