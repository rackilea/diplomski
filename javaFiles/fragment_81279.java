/**
 * Read a settings file and configure this object.
 * 
 * @param fileName Name of the file. Must not be <code>null</code>
 *   or empty.
 * 
 * @throws IOException If an IO error occurs while opening or
 *   reading the file.
 * @throws SecurityException If a security manager exists and its
 *   <code>checkRead()</code> method denies read access to the file.
 */
private void loadSettingsFile(String fileName)
        throws IOException, SecurityException {

    String line;  // Line read from file

    // Read file
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            // Do something with line
        }

    } catch (IOException ex) {
        throw new IOException("IO error reading settings file: " + ex.getMessage(), ex);

    } catch (SecurityException ex) {
        throw new SecurityException("Security error reading settings file: " + ex.getMessage(), ex);

    } catch (Exception ex) {
        throw new IOException(String.format("Unknown error reading settings file: %s: %s", fileName, ex.getMessage()), ex);
    }

    return;
}