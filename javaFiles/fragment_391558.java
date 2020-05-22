int in = 500; 
byte[] data = new byte[2]; // <- assuming "in" value in 0..65535 range and we can use 2 bytes only

data[0] = (byte)(in & 0xFF);
data[1] = (byte)((in >> 8) & 0xFF);

int high = data[1] >= 0 ? data[1] : 256 + data[1];
int low = data[0] >= 0 ? data[0] : 256 + data[0];

int res = low | (high << 8);