public class Application {
    public static void main(String[] args) {
        Race mainRace = new Race();
        mainRace.create();
        System.out.println(mainRace.toString());
    }
}