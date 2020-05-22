public class App { 
    public static void main(String[] args) { 
        PasswordService psd = new DefaultPasswordService(); 
        String password = "333"; 
        String enc = psd.encryptPassword(password); 
        Locale.setDefault(Locale.ENGLISH); 
        System.out.println(Locale.getDefault()); 
        System.out.print(psd.passwordsMatch(password, enc)); 

    } 
}