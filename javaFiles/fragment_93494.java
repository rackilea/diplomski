TIFFEncodeParam tep = new TIFFEncodeParam();

// Create {X,Y}Resolution fields.
TIFFField fieldXRes = new TIFFField(0x11A, TIFFField.TIFF_RATIONAL,
                                1, new long[][] {{DPI_X, 1}});
TIFFField fieldYRes = new TIFFField(0x11B, TIFFField.TIFF_RATIONAL,
                                1, new long[][] {{DPI_Y, 1}});
tep.setExtraFields(new TIFFField[] {fieldXRes, fieldYRes});