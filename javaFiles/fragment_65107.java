// the header is 1 byte I don't see how to make it two
// the command is 2 bytes per the table
// the parameter length is 0 so 1 byte (is there suppose to be a device id?)
byte[] st = new byte[ 1 + 2 + 1 ];

byte header = 0;
// get = 0, set = 1, place = 0
header = SimpleByteSetter(header, 0, 0 ); // get
// header 2 byte = 0, header 2 byte = 1, place = 1
header = SimpleByteSetter(header, 0, 1 ); // header 1 byte
// length 1 byte = 0, length 2 byte = 1
header = SimpleByteSetter(header, 0, 2 );
// command 1 byte = 0, command 2 byte = 1; 
header = SimpleByteSetter(header, 1, 3 );

st[0] = header;
st[1] = 0x0130 & 0xFF; // poweroff command first byte
st[2] = 0x0100 & 0xFF; // poweroff second byte
st[3] = 0;