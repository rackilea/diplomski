StringBuilder line = new StringBuilder();
for (int i = 0; i < this.SalesAmounts.length; i++)
{
    String val = this.SalesAmounts[i] == null || this.SalesAmounts[i].isEmpty() ? "0" : this.SalesAmounts[i];
    line.append(val+"\t");
}
// remove final tab character
line.remove(line.length()-1, line.length()-1);

return line.toString();