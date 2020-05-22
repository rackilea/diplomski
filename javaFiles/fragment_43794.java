boolean IsLocal=true;
if(System.getProperty("IsLocal")!=null){
      IsLocal=System.getProperty("IsLocal");
}

if(IsLocal){
    driver=new FirefoxDriver();
}
else{
    driver= new RemoteWebDriver(HUBURL, DesiredCap);
}