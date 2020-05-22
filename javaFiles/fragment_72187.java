Object[] foo = new Object[3];
foo[0] = new int[] { 1, 2, 3 };
foo[1] = new int[] { 4, 5, 6 };
foo[2] = new int[] { 7, 8, 9 };
...
int nine = ((int[]) (foo[2]))[2];