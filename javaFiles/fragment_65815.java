p.setDestinationType(
    // define the image type to return if supported
    ImageTypeSpecifier.createInterleaved(
                    ColorSpace.getInstance(ColorSpace.CS_sRGB),
                    new int[] {0, 1, 2}, // <-- you are expecting 3 color bands since your image is RGB 
                    DataBuffer.TYPE_BYTE,
                    false,   //<-- this is alpha, your image doesn't have any
                    false)
);