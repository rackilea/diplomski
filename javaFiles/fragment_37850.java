package acme.savingacct;

import java.text.NumberFormat;

public class SavingsAccount {
    private transient double startingRate;
    private transient double currentBalance;
    private transient int startingTerm;

    public SavingsAccount(final double startingRate,
            final double currentBalance, final int startingTerm) {
        this.startingRate = startingRate;
        this.currentBalance = currentBalance;
        this.startingTerm = startingTerm;
    }

    public SavingsAccount() {
        this.startingRate = 0.0;
        this.currentBalance = 0.0;
        this.startingTerm = 0;
    }

    /**
     * @return the term
     */
    public final int getStartingTerm() {
        return startingTerm;
    }

    /**
     * @param term
     *            the term to set
     */
    public void setStartingTerm(final int term) {
        this.startingTerm = term;
    }

    /**
     * @return the rate
     */
    public final double getStartingRate() {
        return startingRate;
    }

    /**
     * @param rate
     *            the rate to set
     */
    public void setStartingRate(final double rate) {
        this.startingRate = rate;
    }

    /**
     * @return the balance
     */
    public final double getBalance() {
        return currentBalance;
    }

    /**
     * @param balance
     *            the balance to set
     */
    public void setBalance(final double balance) {
        this.currentBalance = balance;
    }

    @Override
    public String toString() {
        final StringBuffer htmlSavingsTable = new StringBuffer(1024);
        final NumberFormat currFmt = NumberFormat.getCurrencyInstance();
        final NumberFormat pctFmt = NumberFormat.getPercentInstance();

        // start the html table & create a table heading
        htmlSavingsTable.append("<table border='2'>\n  <tr>\n"
                + "    <th>  -  </th>\n");

        for (int term = getStartingTerm(); term < getStartingTerm() + 5; term++) {
            htmlSavingsTable.append("    <th>" + term + "</th>\n");
        }

        htmlSavingsTable.append("  </tr>\n");

        for (double rate = getStartingRate(); rate < getStartingRate() + 5.0; rate++) {
            // start html table row for rate & add rate to row
            htmlSavingsTable.append("  <tr>\n    <th>"
                    + pctFmt.format(rate / 100.0) + "</th>\n");

            // add monthly payment to row
            for (int term = getStartingTerm(); term < getStartingTerm() + 5; term++) {
                htmlSavingsTable
                        .append("    <td>"
                                + currFmt.format(getNewBalance(rate, term))
                                + "</td>\n");
            }

            // end the row
            htmlSavingsTable.append("  </tr>\n");
        }

        // end the table
        htmlSavingsTable.append("</table>");

        return htmlSavingsTable.toString();
    }

    /**
     * @param aRate
     *            the rate
     * @param aTerm
     *            the term
     * @return the calculated balance
     */
    public double getNewBalance(final double aRate, final int aTerm) {
        double newBalance;
        newBalance = currentBalance * (Math.pow((1 + aRate / 100.0), aTerm));
        return newBalance;
    }

    /**
     * For testing purpose ..
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final SavingsAccount sacc = new SavingsAccount(5.0, 1000.0, 12);
        System.out.println(sacc);
    }

}