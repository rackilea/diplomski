public boolean verifySignIn() {  
       try{  
            setUserName("user");
            setPassword("admin123");
            clickLogin();
            return true;  
       }catch(Exception e){
            return false;
       }  
}