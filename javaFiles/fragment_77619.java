import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class JavaExStockPrice {

    public static void main(String[] args){

        List<Car> al= new ArrayList();
        al.add(new Car(1,100));
        al.add(new Car(2,200));
        al.add(new Car(3,300));

        System.out.println("showsharesbuyingmethod-alltransaction = shares : buying");
        al.forEach(c->c.showSharesBuying() );
        System.out.println("Avg: " + priceAvg(al));
        System.out.println();
        al.removeIf(c->c.shares>1);
        System.out.print("transcation amount 1 share / below");
        System.out.println();
        al.forEach(c->c.showSharesBuying() );
        System.out.println("Avg: " + priceAvg(al));
        System.out.println();
    }

    static double priceAvg(List<Car> l) {
        return l.stream().mapToDouble(c -> c.buying * c.shares).average().getAsDouble() / 
                    l.stream().mapToDouble(c -> c.shares).average().getAsDouble();
    }

}



class Car {
    float shares;
    float buying;

    Car (float a, float b) {
        shares = a;
        buying = b;
    }

    void showSharesBuying() {
        System.out.println("showsharesbuying " + shares+ " : " + buying);
    }
}