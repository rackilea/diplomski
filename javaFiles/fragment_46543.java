static void toPrefixBlocks(String str1, String str2) {
    IPAddressString string1 = new IPAddressString(str1);
    IPAddressString string2 = new IPAddressString(str2);
    IPAddress one = string1.getAddress(), two = string2.getAddress();
    IPAddressSeqRange range = one.toSequentialRange(two);
    System.out.println("starting with range " + range);
    IPAddress blocks[] = range.spanWithPrefixBlocks();
    System.out.println("prefix blocks are " + Arrays.asList(blocks));
}