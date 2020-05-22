// I have 8 strings each containing 32 bit binary words (numbered from w-8 to w-1)
String [] strings = new String[] {
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010",
        "01000010101010100100001010101010"
};
// Make Integers out of them.
List<Integer> ints = Arrays.stream(strings).map(s -> Integer.parseInt(s, 2)).collect(Collectors.toList());
// Reference specific ones by name.
Integer w8 = ints.get(7);
Integer w5 = ints.get(4);
Integer w3 = ints.get(2);
Integer w1 = ints.get(0);
int φ = 0x9e3779b9;


public void test(String[] args) {
    for ( int i = 0; i <= 131; i++ ) {
        int wi = (w8 ^ w5 ^ w3 ^ w1 ^ φ ^ i) << 11;
        System.out.println(Integer.toBinaryString(wi));
    }
}