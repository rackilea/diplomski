private Collection<String> keys( IJavaProject project, String[] bundleNames ) throws CoreException, IOException {

    Set<String> keys = Sets.newLinkedHashSet();

    for( String bundleName : bundleNames ) {

        IPath path = new Path( toResourceName( bundleName ) );

        boolean found = false;

        IPackageFragmentRoot[] packageFragmentRoots = project.getPackageFragmentRoots();
        for( IPackageFragmentRoot root : packageFragmentRoots ) {
            found |= collectKeys( root, path, keys );
        }

        if( ! found ) {
            throw new BundleNotFoundException( bundleName );
        }
    }

    return keys;
}

private boolean collectKeys( IPackageFragmentRoot root, IPath path, Set<String> keys ) throws CoreException, IOException {
    IPath fullPath = root.getPath().append( path );
    System.out.println( "fullPath=" + fullPath );

    IFile file = root.getJavaProject().getProject().getFile( fullPath.removeFirstSegments( 1 ) );
    System.out.println( "file=" + fullPath );

    if( ! file.exists() ) {
        return false;
    }

    log.debug( "Loading " + file );

    InputStream stream = file.getContents( true );
    try {
        Properties p = load( file.getFullPath().toString(), stream );

        keys.addAll( keySet( p ) );
    } finally {
        stream.close();
    }

    return true;
}

protected String toResourceName( String bundleKey ) {

    String path = bundleKey.replace( '.', '/' );
    return path + ".properties";
}