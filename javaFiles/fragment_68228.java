String pathname;
// Full drive:
// pathname = "\\\\.\\PhysicalDrive0";
// A partition (also works if windows doesn't recognize it):
pathname = "\\\\.\\GLOBALROOT\\ArcName\\multi(0)disk(0)rdisk(0)partition(5)";

Path diskRoot = ( new File( pathname ) ).toPath();

FileChannel fc = FileChannel.open( diskRoot, StandardOpenOption.READ,
      StandardOpenOption.WRITE );

ByteBuffer bb = ByteBuffer.allocate( 4096 );

fc.position( 4096 );
fc.read( bb );
fc.position( 4096 );
fc.write( bb );

fc.close();