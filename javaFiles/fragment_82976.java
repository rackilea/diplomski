FileChannel fc = new FileInputStream("content/Video_720p_Madagascar-3.mp4").getChannel();
IsoFile isoFile = new IsoFile(fc);
MovieBox moov = isoFile.getMovieBox();
for(Box b : moov.getBoxes()) {
    System.out.println(b);
}