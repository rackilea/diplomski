int[] a = new int[] { 3 };
int[] b = a; // pointer value of a is copied to b, so a and b now point at the same array object
a[0] = 5;
System.out.println(b[0]); // outputs: 5
a = null; // note: 'a' now points at no array, although this has no effect on b
System.out.println(b[0]); // outputs: 5