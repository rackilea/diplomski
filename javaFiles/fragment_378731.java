try
{
    RandomAccessFile file = new RandomAccessFile( "yourfile.txt" , "rw" );
    FileChannel fc = file.getChannel();
    FileLock fileLock = fc.tryLock();
    if ( fileLock != null )
    {
        // Do stuff on the file
    }
}
catch ( OverlappingFileLockException e )
{
    // File was locked
}