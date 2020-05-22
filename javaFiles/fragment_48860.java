char[] carray = {'n', 'i', 'c', 'k'};
char[] rotated = new char[carray.length];
int pos = carray.length - shift;

System.arraycopy(carray, 0, rotated, shift, pos);
System.arraycopy(carray, pos, rotated, 0, shift);
// outputs 'ckni'
System.out.println(rotated);