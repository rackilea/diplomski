final int id = 1;
    Person person = new Person() {
        @Override
        protected int generateId() {
            return id;
        }
    };

    // test with person, knowing we control id