public static void main(String argv[]) throws IOException {
    String imageFile1 = "resource/4.jpg";
    String imageFile2 = "resource/4_jpg.jpg";

    //copyImage(imageFile1);

    ImageProperties origin = getJpegProperties(new File(imageFile1));
    ImageProperties copyed = getJpegProperties(new File(imageFile2));

    System.out.println("============ Original one ===========");
    System.out.println("comments(origin) : " + origin.getComments());
    System.out.println("Height(origin) : " + origin.getHeight());
    System.out.println("Width(origin) : " + origin.getWidth());
    System.out.println("Header Length(origin) : " + origin.getHeaderLen());
    //System.out.println("suffix(origin) : " + origin.getSuffix());
    System.out.println();
    System.out.println("============ Copy one ===========");
    System.out.println("comments(copy) : " + copyed.getComments());
    System.out.println("Height(copy) : " + copyed.getHeight());
    System.out.println("Width(copy) : " + copyed.getWidth());
    System.out.println("Header Length(copy) : " + copyed.getHeaderLen());
    //System.out.println("suffix(copy) : " + copyed.getSuffix());

}