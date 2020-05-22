private static final int FETCH_SIZE = 100;
    private static final int BATCH_SIZE = 1000;

    //Scrollable results will avoid loading too many objects in memory
    ScrollableResults scroll = query.scroll(ScrollMode.FORWARD_ONLY);
    int batch = 0;
    scroll.beforeFirst();
    while (scroll.next()) {
        batch++;

        index(scroll.get(0)); //index each element

        if (batch % BATCH_SIZE == 0) {
            //flushToIndexes(); //apply changes to indexes
            //optimize();
            //clear(); //free memory since the queue is processed
        }
    }