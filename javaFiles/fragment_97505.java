public static Value[] nextTwo(Iterator<Value> values) {
    return new Value[] {
        (values.hasNext()?values.next():null),  
        (values.hasNext()?values.next():null)
    };
}