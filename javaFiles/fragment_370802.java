Collection<char[]> collection = ...;

char[][] array = new char[collection.size()][];
int index = 0;
for (char[] element : collection) {
  array[index++] = element;
}