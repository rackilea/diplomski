if (obj instance of List) {
    List list = (List) obj;
    for (Object o : list) {
        if (o instanceof Whatever) {
            Whatever w = (Whatever) o;
        }
    }
}