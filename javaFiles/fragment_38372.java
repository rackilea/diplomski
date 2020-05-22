//source is any multistrip image
File file = new File("D:\\Tiff\\image.tif");
BufferedImage src = Imaging.getBufferedImage(file);
OutputStream os = new FileOutputStream(new File("D:\\Tiff\\modified_image.tif"));
os = new BufferedOutputStream(os);
final int width = src.getWidth();
final int height = src.getHeight();
//These are set as per CCITT 4 compression, you can modify these as per requirement
int samplesPerPixel = 1;
int bitsPerSample = 1;
int photometricInterpretation =0;
//setting rowsPerStrip equal to heigh of the image, this did the trick for me
int rowsPerStrip = height;//This code was present originally -> stripSizeInBits / (1 * bitsPerSample * samplesPerPixel);
rowsPerStrip = Math.max(1, rowsPerStrip); // must have at least one.
//you can copy getStrips method from TiffImageWriterBase class or work upon yours own
final byte[][] strips = getStrips(src, samplesPerPixel, bitsPerSample, rowsPerStrip);
for (int i = 0; i < strips.length; i++) {
    strips[i] = T4AndT6Compression.compressT6(strips[i], width,
            strips[i].length / ((width + 7) / 8));
}
final TiffElement.DataElement[] imageData = new TiffElement.DataElement[strips.length];
for (int i = 0; i < strips.length; i++) {
    imageData[i] = new TiffImageData.Data(0, strips[i].length, strips[i]);
}
final TiffOutputSet outputSet = new TiffOutputSet(ByteOrder.LITTLE_ENDIAN);
final TiffOutputDirectory directory = outputSet.addRootDirectory();
directory.add(TiffTagConstants.TIFF_TAG_IMAGE_WIDTH, width);
directory.add(TiffTagConstants.TIFF_TAG_IMAGE_LENGTH, height);
directory.add(TiffTagConstants.TIFF_TAG_PHOTOMETRIC_INTERPRETATION,
        (short) photometricInterpretation);
directory.add(TiffTagConstants.TIFF_TAG_COMPRESSION,
        (short) TiffConstants.TIFF_COMPRESSION_CCITT_GROUP_4);
directory.add(TiffTagConstants.TIFF_TAG_SAMPLES_PER_PIXEL,
        (short) samplesPerPixel);
directory.add(TiffTagConstants.TIFF_TAG_BITS_PER_SAMPLE,
        (short) bitsPerSample);
directory.add(TiffTagConstants.TIFF_TAG_ROWS_PER_STRIP,
        rowsPerStrip);
directory.add(TiffTagConstants.TIFF_TAG_RESOLUTION_UNIT,
        (short) 2);
PixelDensity pixelDensity = PixelDensity.createFromPixelsPerInch(72, 72);
directory.add(TiffTagConstants.TIFF_TAG_XRESOLUTION,
        RationalNumber.valueOf(pixelDensity.horizontalDensityInches()));
directory.add(TiffTagConstants.TIFF_TAG_YRESOLUTION,
        RationalNumber.valueOf(pixelDensity.verticalDensityInches()));
final TiffImageData tiffImageData = new TiffImageData.Strips(imageData,
        rowsPerStrip);
directory.setTiffImageData(tiffImageData);
//single strip image will be written to output stream
new TiffImageWriterLossy().write(os, outputSet);