final byte[] buff = new byte[this.rawFile.length()];    // size the array
inFile.read(buff);                                      // read the whole file in
inFile.close();                                         // close the file descriptor

for (int i = 0; i < buff.length; i++)                   // search the in-memory buffer
{
  if (buff[i] == 0xFF)
  {
    // found marker byte ...
  }
}