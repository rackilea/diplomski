public class Main {

    public static void main(String[] args) {

        Menu newMenu = new Menu();

        boolean continuePlaying = newMenu.menu();

        while (continuePlaying) {
            continuePlaying = newMenu.menu();
        }
    }

}