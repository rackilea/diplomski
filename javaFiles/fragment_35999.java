/**
 * Parses a property list from a file. It can either be in XML or binary format.
 * @param f The property list file
 * @return The root object in the property list
 * @throws Exception If an error occurred while parsing
 */
public static NSObject parse(File f) throws Exception {
    FileInputStream fis = new FileInputStream(f);
    String magicString = new String(readAll(fis, 8), 0, 8);
    fis.close();
    if (magicString.startsWith("bplist00")) {
        return BinaryPropertyListParser.parse(f);
    } else if (magicString.startsWith("<?xml")) {
        return XMLPropertyListParser.parse(f);
    } else {
        throw new UnsupportedOperationException("The given data is neither a binary nor a XML property list. ASCII property lists are not supported.");
    }
}