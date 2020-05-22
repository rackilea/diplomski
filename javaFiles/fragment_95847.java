int c=1,f=0,i;
String[] a=s.split(" ");
Set<String> words = new HashSet<>();
for (i = 0; i < a.length; i++) {
  b = a[i];
  if (words.add(b)) {
    for (int j = i + 1; j < a.length; j++) {
      if (b.equalsIgnoreCase(a[j])) {
        c++;
      }
    }
    if (n == c) {
      f++;
    }
    c = 1;
  }
}