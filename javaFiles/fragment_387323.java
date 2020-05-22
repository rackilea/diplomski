public abstract class Transaction {

private static final double ZERO_AMOUNT = 0.0;

private double myAmount;
private String myTime;
private String myDate;

public Transaction ( String time, String date )
{
    myAmount = ZERO_AMOUNT;
    myTime = time;
    myDate = date;
}