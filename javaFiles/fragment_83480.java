public static void main(String[] args) {
        System.out.println("Sum Of Average:: " + new Average().getSumOfAverage());
    }

    private double getSumOfAverage() {
        return getPart1Average() + getPart2Average() + getPart3Average(); // call all required method here
    }