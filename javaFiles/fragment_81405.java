int x=123456789;
char[] array = x.toString().toCharArray();

int intarray[] = new int[array.length];
for (int i = 0; i < array.length; i++) {
intarray[i] = Integer.parseInt(array[i]);
}