import java.util.*;

class Main
{
    public static String getLine(String bankID, String acctID, String companyName, String month, String day, String year, String seq, String typeCode)
    {
        return new Formatter()
               .format("%3.3s%12.12s%20.20s%2.2s%2.2s%2.2s%12.12s%2.2s", 
                       bankID, acctID, companyName, month,
                       day, year, seq, typeCode)
               .toString(); // 1 semicolon, technically a 1 liner.  aww yeah
    }

    public static void main(String[] args)
    {
        String tester = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(getLine(tester, tester, tester, tester,
                                   tester, tester, tester, tester));
    }
}