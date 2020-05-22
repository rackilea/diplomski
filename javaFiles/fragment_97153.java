public void yourLargeDataSetProcessingMethod() {
    Session session = sessionFactory.getCurrentSession();

    int i = 0;
    for (YourItem item : List<YourItem> items) {
        i++:
        // Here will be processing / creation

        if (i % 50 == 0) {
            session.flush();
            session.clear();
        }
    }
    session.flush();
    session.clear();
}