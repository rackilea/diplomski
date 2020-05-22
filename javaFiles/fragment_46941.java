DoubleStream stream = object.getvalueStream(a,b);
if (condition) {
    stream = stream.map(v -> v * 2);
}
stream.forEach(value -> {
    // do something
}