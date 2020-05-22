Path script = Files.createTempFile(null, ".sh",
    PosixFilePermissions.asFileAttribute(
        PosixFilePermissions.fromString("rw-rw-r--")));

try (InputStream embeddedScript =
    this.getClass().getResourceAsStream("/XXXX.sh")) {

    Files.copy(embeddedScript, script, StandardCopyOption.REPLACE_EXISTING);
}

String[] cmd = { "bash", script.toString() };