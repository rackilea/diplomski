public class Test {

    Random random;
    private int min = 5, max = 20;

    int num1;
    int num2;

    public Test(){
        random = new Random();
        num1 = random.nextInt((max - min) + 1) + min;
        num2 = random.nextInt((max - min) + 1) + min;
    }

    public int getSum(){
        return num1 + num2;
    }

    @Override
    public boolean equals(Test obj) {
        return this.getSum() == obj.getSum();
    }
}