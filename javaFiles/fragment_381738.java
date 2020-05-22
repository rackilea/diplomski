int numOfBytes = binarytring.length() / 8;
byte[] bytes = new byte[numOfBytes];

//store it down as 1 byte (8bits) each
for(int i = 0; i < numOfBytes; ++i) {
    // thanks https://stackoverflow.com/questions/6658388/why-java-throws-a-numberformatexception for help me out of the exception.
    bytes[i] = (byte) (Integer.parseInt(encoded.substring(8 * i, (8 * i) + 8), 2) & 0xFF);
}

FileOutputStream fos = new FileOutputStream("outputfilename"); 
fos.write(bytes);
fos.close();