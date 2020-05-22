// create matrix
ArrayList<ArrayList<Record<T>>> matrix = new ArrayList<ArrayList<Record<T>>>();

// add 3 rows:
for (int i = 0; i < 3; i++) {
    ArrayList<Record<T>> row = new ArrayList<Record<T>>();
    matrix.add(row);

    // add 4 elements to each row
    for (int j = 0; j < 4; j++) {
        Record<T> record = ... // get the record
        row.add(record);
    }
}