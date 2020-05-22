int arrayValue = outp[y * width + x];
int firstByte = (arrayValue >> 8) & 0xFF;
int secondByte = arrayValue & 0xFF;

firstByte = value;
//if you want to edit the second byte:
//secondByte = value;

outp[y * width + x] = (int)(firstByte << 8) + secondByte;