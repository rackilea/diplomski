Object[] fieldsOfT = new Object[testArray.length];
int i = 0;
for (Field f : testArray) {
    fieldsOfT[i++] = f.get(t);
}
for (Object v : fieldsOfT) {
    System.out.println(v);
}