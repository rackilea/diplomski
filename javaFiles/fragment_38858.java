byte[] dataBytes = data.getBytes(Charset.forName("ASCII")); 

for (int lc=0;lc < dataBytes.length ; lc++)
{
    os.writeByte(dataBytes[lc]);
}

byte responseByte = 0;
char response = 0;

responseByte = is.readByte();
response  = (char)responseByte;