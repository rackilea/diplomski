char[] c1 = a.toCharArray();
char[] c2 = b.toCharArray();

Arrays.sort(c1);
Arrays.sort(c2);

return Arrays.equals(c1, c2);  // true -> anagram, false -> not anagram