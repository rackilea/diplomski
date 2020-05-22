// Separator characters, as char, not string.
final static int s1 = ':';
final static int s2 = ';';
// Compute required size:
int components = 1;
for(int p = Math.min(s.indexOf(s1), s.indexOf(s2));
  p < s.length() && p > -1;
  p = s.indexOf(s2, p+1)) {
    components++;
}
String[] result = new String[components];
// Build result
int in=0, i=0, out=Math.min(s.indexOf(s1), s.indexOf(s2));
while(out < s.length() && out > -1) {
  result[i] = s.substring(in, out);
  i++;
  in = out + 1;
  out = s.indexOf(s2, in);
}
assert(i == result.length - 1);
result[i] = s.substring(in, s.length());
return result;