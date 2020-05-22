char* hexStr;
Long original, tag, index,block;

hexStr =  "400a3b";  /* This is hex string to be processed */

original = Long.parseLong(hexStr, 16); /* Long converted from hex string */

tag = (original & 0xFFFF80) >> 7; /* mask higher 17 bits , then shift right 7 bits for TAG */
index = (original & 0x000070) >>4; /* mask 18 to 20 bits , then shift right 4 bit for INDEX */
block = original & 0x00000F; /* mask 21-24 bits for BLOCK */