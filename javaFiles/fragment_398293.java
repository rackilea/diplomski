private void copyFile( String fromPath, File toFile )
    throws IOException
{

    URL fromURL = getClass().getResource( fromPath );

    if ( fromURL == null )
    {
        throw new FileNotFoundException( fromPath );
    }

    FileUtils.copyURLToFile( fromURL, toFile );
}