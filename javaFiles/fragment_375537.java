RenderedOp tiffFile= JAI.create("fileload","C:/test/20060829105323B10506002500200000000011.tiff");

int comp = getCompression(tiffFile);

if(comp == COMPRESSION_GROUP4)
System.out.println("Compression is : GROUP4");