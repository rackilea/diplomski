Object[] x = { "x", "y", "z" };
x[0] = new Object(); // This is fine, because the array really is an Object[]

Object[] y = new String[] { "x", "y", "z" };
y[0] = new Object(); // This compiles, but throws an ArrayStoreException
                     // because the array is really a String[]