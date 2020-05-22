class Bar{
    public static void main(String [] args){
        System.out.println(42); // reference Foo.x will be removed by compiler 
                                // and replaced with actual value because
                                // compiler assumes that value can't/shouldn't
                                // change at runtime
    }
}