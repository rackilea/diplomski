/**
 * Opens a file, with the specified name, for writing.
 * @param name name of file to be opened
 */
private native void open(String name) throws FileNotFoundException;

/**
 * Writes the specified byte to this file output stream. Implements
 * the <code>write</code> method of <code>OutputStream</code>.
 *
 * @param      b   the byte to be written.
 * @exception  IOException  if an I/O error occurs.
 */
public native void write(int b) throws IOException;

/**
 * Writes a sub array as a sequence of bytes.
 * @param b the data to be written
 * @param off the start offset in the data
 * @param len the number of bytes that are written
 * @exception IOException If an I/O error has occurred.
 */
private native void writeBytes(byte b[], int off, int len) throws IOException;