int numPages = decoder.getNumPages();
for(int j = 0; j < numPages; j++)
{
     PlanarImage op = new NullOpImage(decoder.decodeAsRenderedImage(j), null, null, OpImage.OP_IO_BOUND);
     images.add(op.getAsBufferedImage());
}