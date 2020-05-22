byte[] source1 = ListAudio.get(0); //first from list
byte[] source2 = ListAudio.get(1); //second from list

int length = Math.min(source1.length, source2.length);//length of new array
length = length - 44; //skipping 44 byte

byte[] dest = new byte[length];
for(int index = 0; index < length; index ++){
    byte b1 = source1[index+44];
    byte b2 = source2[index+44];
    dest[index] = (byte) ((b1+b2) / 2);
}