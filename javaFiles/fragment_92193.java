PrintStream psFile = /* Open file */;

final int blockSize = 4;

psFile.println("%!PS-Adobe-3.0 EPSF-3.0");
psFile.println("%%BoundingBox: 0 0 " + bitMatrix.getWidth() * blockSize + " " + bitMatrix.getHeight() * blockSize);

psFile.print("/bits [");
for(int y = 0; y < bitMatrix.getHeight(); ++y) {
    for(int x = 0; x < bitMatrix.getWidth(); ++x) {
        psFile.print(bitMatrix.get(x, y) ? "1 " : "0 ");
    }           
}
psFile.println("] def");

psFile.println("/width " + bitMatrix.getWidth() + " def");
psFile.println("/height " + bitMatrix.getHeight() + " def");

psFile.println(
        "/y 0 def\n" + 
        blockSize + " " + blockSize + " scale\n" + 
        "height {\n" +
        "   /x 0 def\n" +
        "   width {\n" +
        "      bits y width mul x add get 1 eq {\n" +
        "         newpath\n" +
        "         x y moveto\n" +
        "         0 1 rlineto\n" +
        "         1 0 rlineto\n" +
        "         0 -1 rlineto\n" +
        "         closepath\n" +
        "         fill\n" +
        "      } if\n" +
        "      /x x 1 add def\n" +
        "   } repeat\n" +
        "   /y y 1 add def\n" +
        "} repeat\n");
psFile.close();