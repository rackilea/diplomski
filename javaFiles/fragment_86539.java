BufferedImage[] images = new BufferedImage[3];
    images[0]=compressedFront;
    images[1]=frontBinaryImage;
    images[2]=backBinaryImage;


    ImageParam.ImageParamBuilder builder = ImageParam.getBuilder();

    TIFFOptions tiffOptions = new TIFFOptions();
    tiffOptions.setTiffCompression(Compression.JPG);
    tiffOptions.setJPEGQuality(35);


    ImageParam[] param = new ImageParam[3];
    param[0] =  builder.colorType(ImageColorType.GRAY_SCALE).imageOptions(tiffOptions).build();

    tiffOptions = new TIFFOptions(tiffOptions); // Copy constructor
    tiffOptions.setTiffCompression(Compression.CCITTFAX4);


    param[1] =  builder.colorType(ImageColorType.BILEVEL).imageOptions(tiffOptions).build();

    tiffOptions = new TIFFOptions(tiffOptions);
    tiffOptions.setTiffCompression(Compression.CCITTFAX4);

    param[2] = builder.colorType(ImageColorType.BILEVEL).imageOptions(tiffOptions).build();

    TIFFTweaker.writeMultipageTIFF(rout, param, images);

    rout.close();
    fout.close();