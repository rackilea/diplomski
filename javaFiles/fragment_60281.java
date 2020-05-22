String temp = "1 3 5 7 6";
String[] tokens = temp.split("\\s+");
int[] array1 = new int[tokens.length];
for (int i = 0; i < tokens.length; i++) {
    array1[i] = Integer.parseInt(tokens[i]);
}
System.out.println(Arrays.toString(array1));