long crc = crc32.getValue();

crc &= 0x7FFFFFFF; //sets the highest bit to 0
if (yourCondition) {
    crc |= 0x80000000; //sets the highest bit to 1
}