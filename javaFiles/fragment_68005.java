class Box<T extends Number> {
    T length;
    T breadth;

    T area(T w , T h) {
        if (w instanceof Double) {
            return (T) w.getClass().cast(w.doubleValue() * h.doubleValue()); 
        }
        if (w instanceof Long) {
            return (T) w.getClass().cast(w.longValue() * h.longValue()); 
        }
        if (w instanceof Integer) {
            return (T) w.getClass().cast(w.intValue() * h.intValue()); 
        }
        throw new IllegalArgumentException();
    }
}