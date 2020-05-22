/*
ACC_VOLATILE = 0x0040 = 10000000
ACC_PUBLIC   = 0x0001 = 00000001
Public and volatile is= 10000001
*/


publicCount += flag & ACC_PUBLIC > 0 ? 1 : 0;
volatileCount += flag & ACC_VOLATILE > 0 ? 1 : 0;