private AbstractPath castPath(Path path) {
    if (!(path instanceof AbstractPath)) {
        throw new ProviderMismatchException("expected a path of provider " +
            SCHEME + " but got " + path.getFileSystem().provider().getScheme());
    }
    return (AbstractPath) path;
}