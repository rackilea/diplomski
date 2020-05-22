public class Main {

        public static void main(String[] args) {
            Zoo z1 = new Zoo("Zoo1");
            Zoo z2 = new Zoo("Zoo2");

            Animal pen1 = new Penguin("Luke");
            Animal gir1 = new Giraffe("Duke");
            Animal pen2 = new Penguin("Fluke");
            Animal tig1 = new Tiger("Brooke");

            pen1.setZoo(z1);
            pen2.setZoo(z2);
            gir1.setZoo(z2);
            tig1.setZoo(z2);

            System.out.println(pen1.belongsWhere());
            System.out.println(tig1.belongsWhere());

            System.out.println(z1); System.out.println(z2);
        }
}