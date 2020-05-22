if ( useManifestOnlyJar )
{
    File jarFile;
    try
    {
        jarFile = createJar( classPath );
    }
    catch ( IOException e )
    {
        throw new SurefireBooterForkException( "Error creating archive file", e );
    }

    cli.createArg().setValue( "-jar" );

    cli.createArg().setValue( jarFile.getAbsolutePath() );
}
else
{
    cli.addEnvironment( "CLASSPATH", StringUtils.join( classPath.iterator(), File.pathSeparator ) );

    final String forkedBooter = ForkedBooter.class.getName();

    cli.createArg().setValue( shadefire ? new Relocator().relocate( forkedBooter ) : forkedBooter );
}