int[] values1 = new int[] { 1, 2, 3 ,4 };
ArrayList<int[]> al1 = new ArrayList<int[]>();
al1.add(values1);

int[] values2 = new int[] { 1, 2, 3 ,4 };
ArrayList<int[]> al2 = new ArrayList<int[]>();
al2.add(values2);

ArrayList<int[]>[] arrayOfIntArrays = new ArrayList[] { al1, al2 };

Intent i = new Intent(this, DemoActivity.class);
i.putExtra("blah", arrayOfIntArrays);