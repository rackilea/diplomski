import java.util.*;

public class Pond {

ArrayList<Fish> fishInPond = new ArrayList<>();


public void addFish(Fish e) {

    fishInPond.add(e);
}

public void showFishes() {
    for (int i= 0; i<fishInPond.size();i++) {
        fishInPond.get(i);
   } 
    System.out.println("Fishes in my pond: " + fishInPond);
}


    public static void main(String[]args) {
        Pond myPond = new Pond();
        myPond.addFish(new Fish("Tilapia"));
        myPond.addFish(new Fish("cat fish"));

        myPond.showFishes();
    }