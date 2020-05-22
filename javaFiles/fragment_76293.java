public static void main(String[] clargs) {
    before("/*", (req, res) -> {
       Base.open(); //will pickup 'development' connection from property file 
    });
    after("/*", (req, res) -> {
        Base.close(); // really connection goes back to pool
    });
    get("/exit", (req, res) -> {
        System.exit(0);
        return "Application shutdown";
    });
}