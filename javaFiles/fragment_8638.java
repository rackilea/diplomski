public class Atom {
int number;
String symbol;
String fullName;
float weight;

static void createAtoms(Atom[] a) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < a.length; i++) {
        a[i] = new Atom();
        System.out.print("Enter atomic number : ");
        a[i].number = sc.nextInt();
        System.out.print("Enter symbol : ");
        a[i].symbol = sc.next();
        System.out.print("Enter full name : ");
        a[i].fullName = sc.next();
        System.out.print("Enter atomic weight : ");
        a[i].weight = sc.nextFloat();
        System.out.print("\n");
    }
}

static void displayAtoms(Atom[] a) {
    for (int i = 0; i < a.length; i++) {
        System.out.println(a[i].toString());
    }
}

@Override
public String toString() {
    return "Atom{" +
            "number=" + number +
            ", symbol='" + symbol + '\'' +
            ", fullName='" + fullName + '\'' +
            ", weight=" + weight +
            '}';
}

public static void main(String[] args) {
    Atom[] atoms;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n: ");
    int atomsNumber = sc.nextInt();

    atoms = new Atom[atomsNumber];
    createAtoms(atoms);
    displayAtoms(atoms);

}
}