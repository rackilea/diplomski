import java.io.File;

public static void main(String[] args) {
    String path = "C:\\Ian\\sample\\install.info"; // Changed variable name from Path to path
    File file = new File(path);                    // Creating file object
    List<String> batchList = new ArrayList<String>(); // Changed variable name from BatchList to batchList
    List<String> installList = new ArrayList<String>();
    List<String> uninstallList = new ArrayList<String>();
    Scanner scanner = null;
    try {
        scanner = new Scanner(file);               // Reading file object
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    String myLine;
    int i = 0;
    while (scanner != null && scanner.hasNext()) {
        if ((myLine = scanner.next()) != null) {
            if (myLine.indexOf("C:\\Batch") == 0) {
                batchList.add(myLine);
            }
            if (myLine.indexOf("C:\\install") == 0) {
                installList.add(myLine);
            }
            if (myLine.indexOf("C:\\uninstall") == 0) {
                uninstallList.add(myLine);
            }
            i++;
        }
    }
    if (scanner != null) {
        scanner.close(); // Closing scanner
    }
    // System.out.println(batchList);
    // System.out.println(installList);
    // System.out.println(uninstallList);

    String[] BatchPath = batchList.toArray(new String[0]);
    String[] SQLinsPath = installList.toArray(new String[0]);
    String[] SQLuninsPath = uninstallList.toArray(new String[0]);

    System.out.println("Batch List : ");
    for (String k : BatchPath) {
        System.out.println(k);
    }
    System.out.println();

    System.out.println("Install List : ");
    for (String k : SQLinsPath) {
        System.out.println(k);
    }
    System.out.println();

    System.out.println("Uninstall List : ");
    for (String k : SQLuninsPath) {
        System.out.println(k);
    }
}