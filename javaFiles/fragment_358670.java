InputStream is = new BufferedInputStream(new FileInputStream(filename));
 // read some data or skip to where you want to start.

 CountingInputStream cis = new CountingInputStream(is);
 GZIPInputStream gzis = new GZIPInputStream(cis);
 // read some compressed data
 dis.read(...);

 int dataRead = cis.counter;