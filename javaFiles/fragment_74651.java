public void your_method() { 
     // Other statements

    synchronized( this ) { // blocks "this" from being executed by parallel threads
      // call your oracle stored proc here
    } 

}