public class Client {

public static void main(String[] args) {
    List<Product> productList = new ArrayList<>();

    Battery energizer = new Battery("Energizer", 12d, true);
    energizer.add2propMap("numInPackage", new Integer(8));
    energizer.add2propMap("make", "US");
    productList.add(energizer);

    CdDrive superDrive = new CdDrive("Apple Drive", 200d, "200 GB");
    superDrive.add2propMap("type", "External");
    superDrive.add2propMap("expandable", false);
    productList.add(superDrive);

    productList.forEach(p -> System.out.println(p));
}