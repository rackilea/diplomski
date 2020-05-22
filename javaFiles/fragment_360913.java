String[][] array = new String[list.size()][];

int i = 0;
for (List<String> nestedList : list) {
    array[i++] = nestedList.toArray(new String[nestedList.size()]);
}