public String convertTime()
{
    String timeDigit = "12";
    String suffix = "AM";
    String output = null;
    output = timeDigit + suffix;
    return output;
}

public void main(String args[])
{
   String output = convertTime();
   System.out.println(output);
}