FileInputStream fs = new FileInputStream(...);

int byte1 = fs.read();
int byte2 = fs.read();
int byte3 = fs.read();
int data = (byte3 << 16) | (byte2 << 8) | byte1;