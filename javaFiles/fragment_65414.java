char[] a = String.valueOf(number).toCharArray();
for (int i = 0; i < a.length - 1; i += 2) {
    char tmp = a[i];
    a[i] = a[i + 1];
    a[i + 1] = tmp;
}
int number = Integer.parseInt(new String(a));