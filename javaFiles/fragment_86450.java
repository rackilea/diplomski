public double foo(Double a, Double b) {

    //as per Marco suggestion. but not sure OP wants the same.
    if(a == null && b == null){
          return 0;
    } 
    //END
    if(a == null || b == null){
          return 999999;
    }    
    return b-a;  //will return 0 if they are equal. no extra checks required
}