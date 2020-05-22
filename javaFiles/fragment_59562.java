public URI toURI() {
    try {
        File f = getAbsoluteFile();
        String sp = slashify(f.getPath(), f.isDirectory());
        if (sp.startsWith("//"))
        sp = "//" + sp;
        return new URI("file", null, sp, null);
    } catch (URISyntaxException x) {
        throw new Error(x);     // Can't happen
    }
    }