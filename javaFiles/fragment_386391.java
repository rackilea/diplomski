private static <X,Y> LinkedList<Y> map(Function<X, Y> obj, LinkedList<X> xs) {
    LinkedList<Y> res = new LinkedList<>();
    for (X x:xs){ //Lambda also possible
        res.add(obj.apply(x));
    }
    return res;
}