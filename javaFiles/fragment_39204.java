// Declarations for `first` and `second` for clarity
byte[] first = new byte[10];
byte[] second = new byte[10];
// ...presumably fill in `first` and `second` here...

// Copy to `third`
byte[] third = new byte[first.length + second.length];
System.arraycopy(first,  0, third, 0, first.length);
System.arraycopy(second, 0, third, first.length, second.length);