public String GetAsLine()
{
    String line = this.Entity + "\t";

    for (int i = 0; i < this.SalesAmounts.length; i++)
    {
        String val = this.SalesAmounts[i] == null || this.SalesAmounts[i].isEmpty() ? "0" : this.SalesAmounts[i];
        line += i < this.SalesAmounts.length - 1 ? val + "\t" : val;
    }

    return line;
}