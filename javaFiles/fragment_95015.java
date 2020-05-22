interface Child extends Father, Mother { 
    static void method() { } 
    default void method() { } //inherited from Mother
    default void demo(){
        method(); //which code block should be executed?
    }
}