boolean run = true;
 while(run){
    ex.a = --val;
    try{
       run = ex.operation();
    }catch(RuntimeException e){
        System.out.println("try exception");
    }    
 }