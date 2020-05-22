public <T> boolean checkValue(Callable<T> valueGetter, T value) {
    return value.equals(valueGetter.call());
}

final MyObject obj = new MyObject();
checkValue(new Callable<String>() { 
     public String call() { return obj.getLevelOne().getLevelTwo().getValue(); }
}, "foo");