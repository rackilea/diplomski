public static void main(String[] args) {
    String[] splitString = "20.3.4.00.1".split("\\.");
    String output = "";
    for(String a : splitString)
    {
        if(a.length() < 2)
        {
            a = "0" + a;
        }
        output += a + ".";
    }
    output = output.substring(0, output.length() - 1);
    System.out.println(output);
}