class Test {
    public static void main(String[] args) {
        Queue<Integer> numbers = new CircularFifoQueue<>(2);
        for (int i = 0; i < 4; i++) {
            numbers.add(i);
            System.out.println("Iteration#" + i + " : " + numbers);
        }
    }
}

// Output:
// Iteration#0 : [0]
// Iteration#1 : [0, 1]
// Iteration#2 : [1, 2]
// Iteration#3 : [2, 3]