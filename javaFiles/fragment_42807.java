import com.currency.*;
public class Bank {
    public static void main(String[] args){
        Yen yen = new Yen(34);
        yen.setKurs(1.0/130);
        System.out.println(yen.dollarBetrag());
    }
}