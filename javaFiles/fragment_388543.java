public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter your text");  
    String textToEncrypt = keyboard.next();

    String encrypted = DesEncrypter.NAGASAKTI.encrypt(textToEncrypt);

    System.out.println("encrypted text=  "+ encrypted);
}