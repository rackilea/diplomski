Set<Integer> insertedNumbers = new HashSet<>(newaR.length);
int index = 0;
for(int i = 0 ; i < aR.length ; ++i) {
    if(!insertedNumbers.contains(aR[i])) {
        newaR[index++] = aR[i];
    }
    insertedNumbers.add(aR[i]);
}