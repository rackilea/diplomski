public class WriteBankDetails {

   public static void main(String[] args) throws IOException {
     ObjectOutputStream objectStream1 = 
                new ObjectOutputStream(new FileOutputStream("bankAccounts.txt"));
        objectStream1.writeObject(new BankAccount());
        objectStream1.close();

    }
}