int len = 260;

byte highByte = (byte)(len >> 8);
byte lowByte = (byte)(len & 255);

Console.WriteLine("highByte = {0:X2}", highByte);
Console.WriteLine("lowByte = {0:X2}", lowByte);