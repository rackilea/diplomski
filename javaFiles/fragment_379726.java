public static void main(String[] args) 
{
    System.out.println ("Enter phone number:");
    Scanner scanInput = new Scanner (System.in);
    String initialPhoneNumber;
    initialPhoneNumber = scanInput.nextLine ();

    initialPhoneNumber = initialPhoneNumber.toUpperCase();
    long convertedPhoneNumber = phoneNumber (initialPhoneNumber);
    long subString = (convertedPhoneNumber%10000000);    
    String updatedStringPhone = initialPhoneNumber.substring(0,6)+subString/10000+"-"+subString%10000;
    System.out.println("Updated: "+updatedStringPhone);
    System.out.println ("Converted: " + convertedPhoneNumber);

}