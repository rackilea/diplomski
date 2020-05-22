Image image;

public static void listFilesForFolder(File folder) {
    for (final File fileEntry : folder.listFiles()) {

        Image image;

        try {


            image = ImageIO.read(new File("C://Users//workspace//ImageProcessing//images//" + fileEntry.getName()));

            BufferedImage buffered = (BufferedImage) image;

            int imageHeight = image.getHeight(null);
            int imageWidth = image.getWidth(null);
            yourImageClass.setHeight(imageHeight);
            yourImageClass.setWidth(imageWidth);
            arrayListOfImageClasses.add(yourImageClass);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(fileEntry.getName());

    }
}