$ openssl rsautl -raw -verify -inkey private.pem < sign1 | hd
00000000  00 01 ff ff ff ff ff ff  ff ff ff ff ff ff ff ff  |................|
00000010  ff ff ff ff ff ff ff ff  ff ff ff ff ff ff ff 00  |................|
00000020  26 3b 0a a1 2e b9 32 db  b8 dc d3 6f 37 94 0b 05  |&;....2....o7...|
00000030  71 9c ba 79 46 34 28 9f  5c 5b 98 9a 64 61 c9 ec  |q..yF4(.\[..da..|

$ openssl rsautl -raw -verify -inkey private.pem < sign2 | hd
00000000  00 01 ff ff ff ff ff ff  ff ff ff ff 00 30 31 30  |.............010|
00000010  0d 06 09 60 86 48 01 65  03 04 02 01 05 00 04 20  |...`.H.e....... |
00000020  26 3b 0a a1 2e b9 32 db  b8 dc d3 6f 37 94 0b 05  |&;....2....o7...|
00000030  71 9c ba 79 46 34 28 9f  5c 5b 98 9a 64 61 c9 ec  |q..yF4(.\[..da..|