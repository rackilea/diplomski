public class Transaction {

    private String debtor = "";
    private String receiver = "";

    public Transaction(){
    }
    public Transaction(String debtor, String receiver){
        this.debtor = debtor;
        this.receiver = receiver;
    }

    public void setDebtor(String debtor){ this.debtor = debtor; }
    public void setReceiver(String receiver){ this.receiver = receiver; }

    public String getDebtor(){ return this.debtor; }
    public String getReceiver() { return this.receiver; }
}