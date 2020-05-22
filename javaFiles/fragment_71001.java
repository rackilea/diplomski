int[] byteRange = sig.getByteRange();
if (byteRange.length != 4)
{
    System.err.println("Signature byteRange must have 4 items");
}
else
{
    long fileLen = infile.length();
    long rangeMax = byteRange[2] + (long) byteRange[3];
    // multiply content length with 2 (because it is in hex in the PDF) and add 2 for < and >
    int contentLen = contents.getString().length() * 2 + 2;
    if (fileLen != rangeMax || byteRange[0] != 0 || byteRange[1] + contentLen != byteRange[2])
    {
        // a false result doesn't necessarily mean that the PDF is a fake
        // see this answer why:
        // https://stackoverflow.com/a/48185913/535646
        System.out.println("Signature does not cover whole document");
    }
    else
    {
        System.out.println("Signature covers whole document");
    }
    checkContentValueWithFile(infile, byteRange, contents);
}