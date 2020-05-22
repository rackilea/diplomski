String sPassword = pssfldLoginPsw.getText();
boolean match = sPassword.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");

if (match==false) 
{                            
    System.out.println("Didn't Work");                    
}

if (match==true) 
{
    System.out.println("Work"); 
}