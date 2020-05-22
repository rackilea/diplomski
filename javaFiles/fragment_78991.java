try {
     ...   
   }    
catch (IOException ex) {
    ...
    }
catch (NullPointerException ex) {
    showError("NullPointerException catch");
    System.out.println("Inside NullPointerException-Catch Block");  
    }
finally{
    ....
    }