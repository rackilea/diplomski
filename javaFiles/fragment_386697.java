public void processVarargIntegers(String label, Class<?>... others) {
    System.out.println(String.format("processing %s arguments for %s", others.length, label));
    Arrays.asList(others).forEach(a -> {
        try {
            if (a == Integer.class) {
                System.out.println(" >>>>>>>>>>>>> Integer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
}