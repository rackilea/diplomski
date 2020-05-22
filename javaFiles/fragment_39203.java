final String s = "Sqrt[A+B] + Sqrt[Min[A,B]] * Min[Sqrt[C],D]";
final char[] charArray = s.toCharArray();

int index = s.indexOf("Sqrt[");
while (index != -1) {
    final int open = index + 4;
    charArray[open] = '(';

    // look for closing bracket
    int close;
    int matching = 0;
    for (close = open + 1; close < charArray.length; close++) {
        char c = charArray[close];
        if (c == ']') {
            if (matching == 0) {
                break;
            }
            matching--;
        } else if (c == '[') {
            matching++;
        }
    }
    charArray[close] = ')';
    index = s.indexOf("Sqrt[", index + 1);
}
System.out.println(new String(charArray));