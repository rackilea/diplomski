B b= new B();
        B z = null; 
        if( z instanceof B){
           z=b;
           System.out.println("yes");
        } else{
           z = new B();
           System.out.println("no");
        }