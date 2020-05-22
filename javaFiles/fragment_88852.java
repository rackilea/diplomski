List<List<B>> listOfLists;
for (List<B> list : listOfLists) {
    for (B b : list) {
        int shape = b.shape;
        int time = -1;
        if (b instanceof D) time = ((D)b).time;
        // do something with shape and time...
    }
}