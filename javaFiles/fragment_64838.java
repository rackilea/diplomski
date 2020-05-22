public List<Double> getTop(List<Double> inputs) {
    List<Double> top = new LinkedList<>();
    for (Double input : inputs) {
        int i = 0;
        while (i < 5 && i < top.size() && input < top.get(i))
            i++;
        if (i < 5)
            top.add(i, input);
    }
    return top.subList(0, 5);
}