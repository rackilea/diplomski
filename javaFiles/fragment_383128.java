/**
 * Constructs a new Scanner that produces values scanned
 * from the specified file. Bytes from the file are converted into
 * characters using the specified charset.
 *
 * @param  source A file to be scanned
 * @throws FileNotFoundException if source is not found
 */
public Scanner(File source) throws FileNotFoundException {
    this((ReadableByteChannel)(new FileInputStream(source).getChannel()));
}