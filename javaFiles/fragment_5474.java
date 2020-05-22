import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test {
    private static final int MAX_LIMIT = 2;

    public static void main(String[] args) throws Exception {
        ArrayList<Package> packages = new ArrayList<>();

//change the path name
        String path = "G:/data.csv";

        parseCSVFile(path, packages);


        updateProductVersion(packages);

    }

    private static void updateProductVersion(ArrayList<Package> packages) {
        HashMap<String, String> latestVersionOfProducts = new HashMap<>(packages.size());
        for (Package p : packages) {
            String currentProduct = p.product;
            String currentVCode = Package.computeVCode(p.version);

            if (!latestVersionOfProducts.containsKey(currentProduct)) {
                latestVersionOfProducts.put(currentProduct, p.version);
            } else {
                String setVersion = latestVersionOfProducts.get(currentProduct);
                if (currentVCode.compareTo(Package.computeVCode(setVersion)) > 0) {
                    latestVersionOfProducts.put(currentProduct, p.version);
                }
            }
        }
        showLatestVersionsOfProducts(latestVersionOfProducts);

        detectOutdatedSystems(packages, latestVersionOfProducts);
    }

    private static void detectOutdatedSystems(ArrayList<Package> packages, HashMap<String, String> latestVersionOfProducts) {
        Set<Map.Entry<String, String>> products = latestVersionOfProducts.entrySet();
        boolean allNew = true;
        for (Map.Entry<String, String> product : products) {
            String productName = product.getKey();
            String productVersion = product.getValue();

            ArrayList<Package> outdates = new ArrayList<>();
            for (Package p : packages) {
                if (p.product.equalsIgnoreCase(productName) && !p.version.equalsIgnoreCase(productVersion)) {
                    outdates.add(p);
                }
            }
            if (outdates.size() >= MAX_LIMIT) {
                displayOutdates(outdates, productName);
                allNew = false;
            }
        }
        if (allNew) {
            System.out.println("All systems upto date");
        }
    }

    private static void displayOutdates(ArrayList<Package> outdates, String productName) {
        System.out.println(outdates.size() + " systems using outdated version of " + productName);
        for (Package aPackage : outdates) {
            System.out.println(aPackage);
        }
        System.out.println("---------------");
    }

    private static void showLatestVersionsOfProducts(HashMap<String, String> latestVersionOfProducts) {
        System.out.println("-----------------------------------------");
        System.out.println("latest versions detected are");
        Set<Map.Entry<String, String>> entries = latestVersionOfProducts.entrySet();
        System.out.println("\nVersion\t\tProduct");
        for (Map.Entry<String, String> entry : entries) {
            System.out.format("%-7s\t\t%s\n", entry.getValue(), entry.getKey());
        }
        System.out.println("-----------------------------------------");
    }


    private static void parseCSVFile(String path, ArrayList<Package> packages) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext())
            packages.add(new Package(scanner.nextLine()));
    }


    static class Package {
        String machine;//Server
        String type;//Database or OS or other
        String product;//Oracle or other
        String version;//version number


        public Package(String line) {
            String[] contents = line.split(",");
            machine = contents[0].trim();
            type = contents[1].trim();
            product = contents[2].trim();
            version = contents[3].trim();
        }

        public static String computeVCode(String version) {
            return version.replace(".", "").replaceAll(" ", "").toLowerCase().trim();
        }

        @Override
        public String toString() {
            return product + ' ' + type + " version:" + version + " is installed on " + machine;
        }
    }
}