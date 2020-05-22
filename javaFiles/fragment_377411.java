for( final String s : value ) {
    doSomething( new InnerClass() {
       void something() {
             s.length();// accesing s from within the inner class 
       }
    });
 }