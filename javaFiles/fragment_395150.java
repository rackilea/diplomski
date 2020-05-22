public static class Task2 implements Function<String, Integer> {

    public Task2() {
        System.out.println("Task 2 started");
    }

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}