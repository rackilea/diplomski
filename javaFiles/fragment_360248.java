1 BufferedInputStream bis = new BufferedInputStream(is);
2 byte[] b = new byte[4];
3 bis.read(b); // read 4 bytes into b
4 bis.mark(10); // mark the stream at the current position - we can read 10 bytes before the mark point becomes invalid
5 bis.read(b); // read another 4 bytes into b
6 bis.reset(); // resets the position in the stream back to when mark was called
7 bis.read(b); // re-read the same 4 bytes as line 5 into b