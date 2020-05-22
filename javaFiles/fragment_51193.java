private void checkRelativeAge(TreeSet<Integer> ageGroup, int relAge, 
int boundary, int offset) {
    if (relAge > boundary & relAge <= boundary + offset) {
        ageGroup.add(relAge);
    }
}