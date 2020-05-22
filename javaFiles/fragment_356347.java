int max = 10;
ArrayList<Integer> array = new ArrayList<Integer>();

for (int x = 0; x < max; x++) {
    if (x % 2 != 0) {
        array.add(x);
    }
}
System.out.println(array);
}