private void loadStatistics() {
    mStatisticsView.setProgressIndicator(true);

    // The network request might be handled in a different thread so make sure Espresso knows
    // that the app is busy until the response is handled.
    EspressoIdlingResource.increment(); // App is busy until further notice

    mTasksRepository.getTasks(new TasksDataSource.LoadTasksCallback() {
    //snip