int[] counters = new int[0x100];
for(int i = 0; i < string.length(); i++) {
    char c = string.charAt(i);
    counters[(int) c]++;
}
for(char c = 'a'; c <= 'z'; c++) {
    System.out.println("There are "+counters[(int) c]+" "+c+"'s in the String.");
}