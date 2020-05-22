public class Main implements Foo {
    public static void main(String... args) {
        Banana ban = new Banana();
        String[] listOfBananas = ban.getBananas();
        System.out.println("I didnt get to this statement");
    }
}

class Banana {
    public static String[] giveOtherClassList;

    public Banana() {
    }

    public String[] getBananas() {
        return giveOtherClassList;
    }
}