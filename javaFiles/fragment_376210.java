public abstract class accounts_class {
    private String account_number;
    private String name;
    private String phone_number;
    private String ssn;
    private double balance;
    private String account_type;

    public String get_name()
         {
    {return name;}

    public void set_balance(double balance)
    {


       this.balance = balance;

    }

    public abstract double computeInterest();
}