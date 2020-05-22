byte b = 0, pot = 1;
for (int i = 5; i >= 0; i--) {
    // -48: the character '0' is No. 48 in ASCII table,
    // so substracting 48 from it will result in the int value 0!
    b += (str.charAt(i)-48) * pot;
    pot <<= 1;    // equals pot *= 2 (to create the multiples of 2 (1,2,3,8,16,32)
}