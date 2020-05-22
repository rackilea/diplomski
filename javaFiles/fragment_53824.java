int dimension = 5;
int number    = 10;

Vector<Double> v = new Vector<Double> (dimension);

for (int n = 0; n < number; n++) {
    v.clear();

    for (int m = 0; m < dimension; m++) v.add(Math.random()); // [0..1]

    v.set((int) Math.ceil(Math.random() * dimension) - 1, // random position
                Math.ceil(Math.random() * 2) - 1);        // 0 or 1

    System.out.println("Vector: " + v);
}