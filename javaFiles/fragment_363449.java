index = 1000000 - 1;
line = "HELLO";
int len = line.length();
long len2 = len;
while (len2 <= index) {
    len2 *= 2;
}
while (len2 > len) {
    long lenhalf = len2 / 2;
    if (index >= lenhalf) {
        index -= lenhalf;
        index -= 1;
        if (index < 0) {
            index += lenhalf;
        }
    }
    len2 = lenhalf;
}

System.out.println(line.charAt((int)index));