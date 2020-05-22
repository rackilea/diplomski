System.arraycopy(arrayone, 0, mergeQ, 0, integers);
System.arraycopy(arraytwo, 0, mergeQ, integers, inte);
int both[] = Arrays.copyOf(mergeQ,integers+inte);
Arrays.sort(both);
for (int i=0; i< both.length; i++){
    System.out.print(both[i] + " ");
}