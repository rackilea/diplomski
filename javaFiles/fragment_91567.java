public enum FileManagementExecution implements Execution<ConcreteReprisitory> {
    UPLOAD_PERSON_FILE() {
        @Override
        public void execute(ConcreteReprisitory repository, String fileName) {
            //TODO
        }
    },
    DELETE_PERSON_FILE() {
        @Override
        public void execute(ConcreteReprisitory repository, String fileName) {
            //TODO
        }
    }
    // other enum constants
}