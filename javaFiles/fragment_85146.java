class Feedback()
{
    private CustomerDetails result;
    private int status;

    public static final int STATUS_OK = 0;
    public static final int STATUS_NULL = 1;
    public static final int STATUS_NO_CUSTOMER = 2;
    public static final int STATUS_BAD_CONDITION = 3;

    public Feedback(CustomerDetails result, int status)
    {
        this.result = result;
        this.status= status;
    }

    public CustomerDetails getResult(){return result;}
    public int getStatus(){return status;}
}