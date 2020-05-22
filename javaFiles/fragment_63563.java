for (int index = 0; index < 50; index++) {
    String fileName1 = "data1.txt";

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName1, true))) {
        bw.write("1");
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    boolean deleteMe = false;
    try (Scanner scanner = new Scanner(new FileReader("data1.txt"))) {
        String scannerData1 = scanner.nextLine();

        if (scannerData1.length() >= 20) {
            deleteMe = true;
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    if (deleteMe) {
        File file = new File(fileName1);
        if (!file.delete()) {
            System.out.println("!! Could not delete " + file);
        } else {
            System.out.println(file + " was deleted");
        }
        System.out.println(file + " exists = " + file.exists());
    }
}