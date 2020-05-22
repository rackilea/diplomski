Iterator readersIterator = ImageIO.getImageReadersByFormatName("tif");
ImageReader imageReader = (ImageReader)readersIterator.next();
ImageInputStream imageInputStream;
try {
imageInputStream = new FileImageInputStream(new File("C:/test/20060829105323B10506002500200000000011.tiff"));
imageReader.setInput(imageInputStream,false, true);

/* Take a input from a file */
FileSeekableStream fileSeekableStream;
fileSeekableStream = new FileSeekableStream(inputTifImagePath);

/* create ImageDecoder to count your pages from multi-page tiff */
ImageDecoder iDecoder = ImageCodec.createImageDecoder("tiff", fileSeekableStream, null);

/* count the number of pages inside the multi-page tiff */
int pageCount = iDecoder.getNumPages();

/* use first for loop to get pages one by one */
for(int page = 0; page < pageCount; page++){
/* get image metadata for each page */
IIOMetadata imageMetadata = imageReader.getImageMetadata(page);

/*
 * The root of all the tags for this image is the IFD (Image File Directory).
 * Get the IFD from where we can get all the tags for the image.
 */
TIFFDirectory ifd = TIFFDirectory.createFromMetadata(imageMetadata);

/* Create a Array of TIFFField*/
TIFFField[] allTiffFields = ifd.getTIFFFields();

/* use second for loop to get all field data */
for (int i = 0; i < allTiffFields.length; i++) {
TIFFField tiffField = allTiffFields[i];

/* name of property */
String nameOfField = tiffField.getTag().getName();

/* Type of property (optional) */
String typeOfField = TIFFField.getTypeName(tiffField.getType());                                 

/* Tag no. of the property (optional) */
int numberOfField = tiffField.getTagNumber(); }// we are looking for 259, jump optional step out of loop


TIFFField compField = ifd.getField(259);

/* Value of Property*/
int valueOfField = compField.getAsInt(0);