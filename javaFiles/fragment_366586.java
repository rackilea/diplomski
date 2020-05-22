public static List<Account> loadAccounts() throws IOException {
    List<Account> accounts = null;
    try {
        File file = new File("accounts.ser");
        if (file.length() == 0) {
            accounts = new ArrayList<>();
        } else {
            FileInputStream fis = new FileInputStream("accounts.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accounts = (List<Account>) ois.readObject();
            ois.close();
            fis.close();
        }
    }
    catch(IOException ioe) {
        ioe.printStackTrace();
    }
    catch(ClassNotFoundException c) {
        System.out.println("Class not found");
        c.printStackTrace();
    }
    return accounts;
}