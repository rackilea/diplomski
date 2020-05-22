public enum Status {
    SUCCESS("SUCCESS") {

    },
    FAILED("FAILED") {  
        class Test { 
            public void test() {
                System.out.println("test");
            }
        }
    };
    private String code;

    Status(String code) {
        this.code = code;
    }
}