@SuppressWarnings("serial")
    class Browserselection extends JFrame implements ActionListener
    { 
     public void BrowserSelection1(String selectedBrower)
     { 
         WebDriver d1 = null;

        if(selectedBrower.equals("firefox")){
            d1 = new  FirefoxDriver();  
        }else if(selectedBrower.equals("firefox")){
            d1 = new  ChromeDriver();   
        }
     }
     /*  
      As per this code , your input from user will be received in this method
     */
     @Override
     public void actionPerformed(ActionEvent e)
     {
       String driverSelected = "";
        if(FireFox.isSelected()){
            driverSelected =  "firefox";
        }else if(Chrome.isSelected()){
            driverSelected =  "chrome";
        }
        Browserselection bs= new Browserselection();
        bs.BrowserSelection1(driverSelected);

     }
}