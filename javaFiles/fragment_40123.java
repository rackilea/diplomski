public static void main(String... args) throws Exception {
    Map<String, Computable> functions = new HashMap<String, Computable>();
    functions.put("y=x", new Computable() {public double compute(double x) {return x;}});
    functions.put("y=x^2", new Computable() {public double compute(double x) {return x*x;}});

    for(Map.Entry<String, Computable> e : functions.entrySet()) {
        System.out.println(e.getKey() + ": " + e.getValue().compute(5)); //prints: y=x: 5.0 then y=x^2: 25.0
    }
}

interface Computable {
    double compute(double x);
}