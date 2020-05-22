final DoubleProperty result = new SimpleDoubleProperty(0.0);
final LongProperty longProperty1 = new SimpleLongProperty(812323534);
final LongProperty longProperty2 = new SimpleLongProperty(956745323);
result.bind(Bindings.createDoubleBinding(() -> longProperty1.longValue() / (double) longProperty2.longValue(),
    longProperty1, longProperty2));
System.out.println(result.get());
longProperty1.set(612323534);
System.out.println(result.get());