public static void main (String[] args) throws Exception
{
    String input = "32,646,513.32";
    double value = Double.parseDouble(input.replace(",",""));
    String output = String.format("%f",value);
    System.out.println("Value: " + output);
}