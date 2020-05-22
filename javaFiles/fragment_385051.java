File file = new File( "test.dat" );
FileDetails fd = new FileDetails( file );
FileOutputStream fos = new FileOutputStream("oos.dat");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject( fd );
oos.close();

// test on a local system: rename test.dat to avoid overwriting
file.renameTo( new File( "test.dat.sav" ) );

FileInputStream fis = new FileInputStream("oos.dat");
ObjectInputStream ois = new ObjectInputStream(fis);
FileDetails fd1 = (FileDetails)ois.readObject();
ois.close();
// now the file test.dat has been rewritten under the same path,
// i.e., test.dat exists again and test.dat.sav == test.dat