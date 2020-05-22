for (int i=0; i< integers; i++){
   mergeQ[i] = arrayone[i];
}
for (int i=integers; i< inte + integers; i++){
   mergeQ[i] = arraytwo[i - integers];
}
int both[] = Arrays.copyOf(mergeQ,integers+inte);
Arrays.sort(both);
for (int i=0; i< both.length; i++){
    System.out.print(both[i] + " ");
}