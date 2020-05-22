interface A{} 

class AImplementer implements A{};

class B { 
    A[] array; 
    B(){  
        array=new A[]{ new AImplementer(), new AImplementer(), new AImplementer()}; 
    } 
 }