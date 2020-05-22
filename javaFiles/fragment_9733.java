FileOutputStream fileOut = new FileOutputStream("foo.dat");
DataOutputStream dataOut = new DataOutputStream(fileOut);
dataOut.writeInt(numFiles);
dataOut.writeInt(numBytesInName);
dataOut.writeUTF(filename);
dataOut.writeLong(numBytesInFile);
dataOut.write(fileBytes);