<T> void process(List<List<T>> lists) {
    // and at this point we should note that List<T>
    // allows us to add elements to the lists, so we
    // could do something like this:

    if (!lists.isEmpty()) {
        List<T> list0 = lists.get(0);

        for (int i = 1; i < lists.size(); ++i)
            list0.addAll(lists.get(i));
    }
}