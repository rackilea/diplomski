public Readable asReadable(Resource resource) {
    if (resource instanceof Readable)
        return (Readable) resource;
    else if (resource instanceof Wrapper)
        return (asReadable( ((Wrapper) resource).getSource() );
    else
        return null;
}