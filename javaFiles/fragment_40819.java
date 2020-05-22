try {
        ObjectInputStream objectStream2 = new ObjectInputStream(
                new FileInputStream("bankAccounts.txt"));
        account = (BankAccount) objectStream2.readObject();
        objectStream2.close();
} catch (Exception e) {
        e.printStackTrace();
}