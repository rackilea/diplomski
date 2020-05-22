public static void main(String[] args) {
    double goldenRation1 = goldenRatio(1.0, 1.0);
    System.out.println(goldenRation1); // prints 1.618032786885246
    System.out.println(goldenRation1 > 1.61800 && goldenRation1 < 1.61806); // prints true

    double goldenRation2 = goldenRatio(100.0, 6.0);
    System.out.println(goldenRation2); // prints 1.6180367504835589
    System.out.println(goldenRation2 > 1.61800 && goldenRation2 < 1.61806); // prints true
}