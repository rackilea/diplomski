class Scheduler {
    private int[] numbers;
    private AtomicInteger current = new AtomicInteger();

    public Scheduler(int count) {
        Random rand = new Random();
        numbers = new int[count];
        for(int i = 0; i < count; i++) {
            numbers[i] = rand.nextInt();
            if(numbers[i] < 0) numbers[i] *= -1;
        }   
    }

    public int getNextNumber() {
        int local = current.incrementAndGet();
        if(local >= numbers.length) {
            return -1;
        }
        return numbers[local];
    }
}