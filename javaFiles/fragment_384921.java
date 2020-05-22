public enum ConfigLoader{
  INSTANCE;
  private Properties propies;
  private ConfigLoader(){
    propies = new Properties;
  }

  public static ConfigLoader getInstance(){ return INSTANCE; }

  public boolean Load(){
   try{
         propies.load(this.getClass().getResourceAsStream("/config.properties"));          
   }
   catch(NullPointerException e){
         System.out.println("File Does Not Exist");
         return false;
   }
   return true;
   }
}