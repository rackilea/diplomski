String fileName         = "/var/Emails_log/"+filename;
Path filePath           = Paths.get(fileName);
final Path tmp          = filePath.getParent();

if (tmp != null) {      // <== Note: There's no point to this check, given
                        // your filename above, the path WILL have a parent.
                        // You could remove the `if` and just use
                        // `Files.createDirectories(tmp)` unless the `fileName`
                        // is actually coming from somewhere else and so could
                        // be a root (roots don't have parents)
    Files.createDirectories(tmp);
}
else {
    out.write(str);     // I assume this is for logging or display?
    out.write('\n');    // Specifically, that it's *not* trying to write
                        // to the file you're trying to create.
}

try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE)) {
// ------------------------------------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^
    // Write to the file here
}