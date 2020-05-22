try (PDDocument document = PDDocument.load(new File(infile), password))
{
    for (PDSignature sig : document.getSignatureDictionaries())
    {
        int[] byteRange = sig.getByteRange();
        System.out.println("byteRange: " + Arrays.toString(byteRange));
        System.out.println("Range max: " + (byteRange[byteRange.length-2] + byteRange[byteRange.length-1]));
        // multiply content length with 2 (because it is in hex in the PDF) and add 2 for < and >
        System.out.println("Content len: " + (sig.getCOSObject().getString(COSName.CONTENTS).length() * 2 + 2));
        System.out.println("File len: " + new File(infile).length());
(...)