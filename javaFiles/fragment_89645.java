// "8 (4)" reads "8 bytes for x64, 4 bytes for x32"

class String{      //8 (4) house keeping + 8 (4) class pointer
    char[] buf;    //12 (8) bytes + 2 bytes per char -> 24 (16) aligned
    int offset;    //4 bytes                     -> three int
    int length;    //4 bytes                     -> fields align to
    int hash;      //4 bytes                     -> 16 (12) bytes
}