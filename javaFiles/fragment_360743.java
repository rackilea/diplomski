public class Client {
    private String name;
    private String adress;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    public Client(String name,String adress,BankAccount account){
        this.name=name;
        this.adress=adress;
        this.accounts.add(account);
    }

    public void addBankAccount(BBankAccount account){
        this.accounts.add(account);
    }
}