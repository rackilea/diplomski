TiffImageMetadata tmeta = (TiffImageMetadata) metadata;
    TiffOutputSet outputSet = tmeta.getOutputSet();
    byte iccBytes[] = Util.getAdobe98ProfileBytes();
    TagInfoUndefined ICC_INFO = TiffConstants.EXIF_TAG_INTER_COLOR_PROFILE;
    TiffOutputField field = new TiffOutputField(ICC_INFO, FieldType.UNDEFINED, iccBytes.length, iccBytes);
    TiffOutputDirectory rootDirectory = outputSet.getOrCreateRootDirectory();
    rootDirectory.removeField(ICC_INFO);
    rootDirectory.add(field);

    TiffImageWriterLossless writerLossless = new TiffImageWriterLossless(imageBytes);
    writerLossless.write(new FileOutputStream(resultingFilePath), outputSet);