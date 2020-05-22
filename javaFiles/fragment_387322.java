public class ZeroBalance extends Transaction
{

private static final double ZERO_BALANCE_AMOUNT = 0.0;    

public ZeroBalance (String time, String date ) 
    {
        super(time, date,ZERO_BALANCE_AMOUNT);
    }
// ....
// ....
}