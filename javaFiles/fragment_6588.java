import java.util.Random;

public class Randomiser {
    //attribut
    public int ranNumber;    

    //constructeur, called everytime you instanciate an object of this class
    public Randomiser() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(3);           
        this.ranNumber = 10 + randomInt;
        System.out.println("ranNumber : "+this.ranNumber);
    }

}