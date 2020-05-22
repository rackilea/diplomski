public abstract class Bank {
    private int Kontonummer;
    private int blz;

    public Bank(){}

    public Bank(int bankleitzahl){
        this.blz = bankleitzahl;
    }

    public int getBlz()
    {
        return blz;
    }
}

public class Volksbank extends Bank
{
    public Volksbank(int bankleitzahl)
    {
        super(bankleitzahl);
    }
}