byte header = 0;
// get = 0, set = 1, place = 0
header = SimpleByteSetter(header, 0, 0 ); // get
// header 2 byte = 0, header 2 byte = 1, place = 1
header = SimpleByteSetter(header, 0, 1 ); // header 1 byte
...
st[0] = header;