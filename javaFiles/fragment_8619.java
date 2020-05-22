public static boolean isIntegerParseInt(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException nfe) {}
    return false;
}

 public static void main(String []args){

    String postcode;
    String address;
    Scanner scn = new Scanner(System.in); 
    address = scn.next();
    address=address.trim();

    if(address.length() > 3)
    {
        String testPostCode = address.substring(address.length() - 4, address.length());
        if(isIntegerParseInt(testPostCode))
        {
            postcode = testPostCode;
            System.out.println("postcode:" + postcode);
        }
        else
        {
            System.out.println("there is not valide address.");
        }
    }
 }