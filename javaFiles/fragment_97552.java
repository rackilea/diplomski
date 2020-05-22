Predicate<Customer> isVip = new Predicate<Customer>() {
        @Override
        public boolean apply(Customer customer) {
            return customer.isVip();
        }
    };

    Predicate<Customer> isConferenceAttendee = new Predicate<Customer>() {
        @Override
        public boolean apply(Customer customer) {
            return customer.isConferenceAttendee();
        }
    };