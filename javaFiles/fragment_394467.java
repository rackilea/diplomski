private static int getComponentsPerPixel(PdfName colorSpaceName, PdfDictionary colorSpaceDic){
        if (colorSpaceName == null)
            return 1;
        if (colorSpaceName.equals(PdfName.DEVICEGRAY))
            return 1;
        if (colorSpaceName.equals(PdfName.DEVICERGB))
            return 3;
        if (colorSpaceName.equals(PdfName.DEVICECMYK))
            return 4;

        if (colorSpaceDic != null){
            PdfArray colorSpace = colorSpaceDic.getAsArray(colorSpaceName);
            if (colorSpace != null){
                if (PdfName.INDEXED.equals(colorSpace.getAsName(0))){
                    return 1;
                }
            }
        }

        throw new IllegalArgumentException("Unexpected color space " + colorSpaceName);
    }