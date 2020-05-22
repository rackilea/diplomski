long longValZ = 219902744986400000L;

ByteBuffer bbX = ByteBuffer.allocate(8);
bbX.putLong(longValZ); 

char[] charArr1 = new char[4];
for (int i = 0; i < charArr1.length; i++)
   charArr1[i] = bbX.getChar();



//convert char array to long

ByteBuffer bbY = ByteBuffer.allocate(8);
for (int i = 0; i < charArr1.length; i++)
    bbY.putChar(charArr1[i]);

long longValY = bbY.getLong(0);