AtomicBoolean b = new AtomicBoolean(false);
l.stream()
        .filter(x -> x.getValue() > 10)
        .forEach(x->{
            x.setAnotherValue(5);
            b.set(true);
        });
if (b.get()){
   throw new RuntimeException();
}