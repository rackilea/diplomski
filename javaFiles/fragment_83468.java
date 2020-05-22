public class Refactor {
    int foo ;
    double[] bar; 

    void f2() {
        for ( int i = 0 ; i < bar.length ; i++ ) {        // selection start
            bar[i] = foo;
        }
        foo = 0;                                          // selection end
    }
}