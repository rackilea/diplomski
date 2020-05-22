// Add ZIP entry to output stream.
out.putNextEntry(new ZipEntry(name));
// Transfer bytes from the ZIP file to the output file
int len;
while ((len = zin.read(buf)) > 0) {
    out.write(buf, 0, len);
}
// ADD THIS LINE:
out.closeEntry();