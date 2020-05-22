final Task<List<User>> searchUserTask = new Task<List<User>>() {
        @Override
        protected List<User> call() throws Exception {
              //search logic, for example call to DB
              return //list of users
        }

    };

    //Here we add a listener to the state, so that we can know when the operation finishes, and decide what to do after
    searchUserTask.stateProperty().addListener((ObservableValue<? extends Worker.State> source, Worker.State oldState, Worker.State newState) -> {

        if (newState.equals(Worker.State.SUCCEEDED)) { //the operation finished successfully
            List<User> result = searchTask.getValue();
            //set value to a UI component (this method runs on the UI thread)
            //usersTable.getItems().setAll(matches);
        } else if (newState.equals(Worker.State.FAILED)) {
            Throwable exception = searchTask.getException();
            log.error("Contact search failed", exception);
        }
    });

    new Thread(searchUserTask).start();