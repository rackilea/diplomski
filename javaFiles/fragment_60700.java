int ReadInt(StreamReader reader) { return Int32.Parse(reader.ReadLine()); }

// in another method:
Stream fileStream = new FileStream("My Data.dat");
Stream zipStream = new ZipDecompressorStream(fileStream);
Stream decryptedStream = new DecryptionStream(zipStream);
StreamReader reader = new StreamReader(decryptedStream);

int x = ReadInt(reader);