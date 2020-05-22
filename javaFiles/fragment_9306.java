static Test foo(final String arg) {
    return new Test() {
        private final String localArg = arg;
        @Override 
            void bar() {
            // I want to set a breakpoint here with the condition "arg==null"
            System.out.println(localArg); 
        }
    };
}