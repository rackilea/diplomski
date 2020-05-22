for(String dmU : Arrays.asList("dmUDNavigationItem_03","dmUDNavigationItem_00","dmUDNavigationItem_02")){
    driver.findElement(By.className(dmU)).click();
    try{
        Thread.sleep(5*1000);
    }catch(InterruptedException ie){
        ie.printStackTrace();
    }
}