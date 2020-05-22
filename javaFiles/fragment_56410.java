public enum LinkStates implements StuffDoneListener {
    // ...

    START_SOME_WORK_AND_WAIT {
        public void process() {
            // ....
            someObject.startDoingSpecialStuff();
        }

        public void onSpecialStuffComplete() {
            outerClass.toState(EVENT_IS_COMPLETE);
        }
    },

    EVENT_IS_COMPLETE {
        public void process() {
            // ...
        }
        // ...
    }

    // ...

    public void onSpecialStuffComplete() {
    }
}