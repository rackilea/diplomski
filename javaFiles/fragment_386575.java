public class FutureTuition{
    public static void main(String[] args) {
        double tuition = 10000;
        //7% of tuition = 7/100 * 10000 = 700
        Integer year = 0;

        while(tuition < 20000){
            tuition = tuition * 1.07;
            year++;
        }

        System.out.println("Tuition will be doubled in " + year + " years");}

}