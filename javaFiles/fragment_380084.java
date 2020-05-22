public static final int TEST = 0x4;
// TEST:    0000 0000 0000 0000 0000 0000 0000 0100

value = 35;
// value:   0000 0000 0000 0000 0000 0000 0010 0011

final boolean b1 = (value & TEST) == TEST; // FALSE

value = 70;
// value:   0000 0000 0000 0000 0000 0000 0100 0110

final boolean b1 = (value & TEST) == TEST; // TRUE