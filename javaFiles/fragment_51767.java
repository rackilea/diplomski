ProtectionDomain protectionDomain = getClass().getProtectionDomain();
CodeSource codeSource = protectionDomain.getCodeSource();
URI location = (codeSource != null) ? codeSource.getLocation().toURI() : null;
String path = (location != null) ? location.getSchemeSpecificPart() : null;

if (path == null) {
    throw new IllegalStateException("Unable to determine code source archive");
}

File root = new File(path);
if (!root.exists()) {
    throw new IllegalStateException(
            "Unable to determine code source archive from " + root);
}