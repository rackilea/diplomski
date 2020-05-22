int[] ints = {0b10010, 0b01011, 0b00111, 0b10100, 0b00101};
int setOnce = 0, setMore = 0;
for (int i : ints) {
    setMore |= setOnce & i;
    setOnce |= i;
}
int result = setOnce & ~setMore;
System.out.println(String.format("%5s", Integer.toBinaryString(result)).replace(' ', '0'));