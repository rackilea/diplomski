// Create a list with all the values (maybe use a hashset to prevent duplicates)
List<int> all = new List();
all.addAll(A);
all.addAll(B);

//for each loop
for (int i : all) {
    boolean inA = A.contains(i);
    boolean inB = B.contains(i);
    if (inA && inB) {
    // You can figure out the rest of these statements I think
    }
}