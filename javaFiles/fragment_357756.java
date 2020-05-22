public enum FieldType {
    NAME {
        @Override
        public boolean areEqual(ConferenceInfo c1, ConferenceInfo c2) {
            return c1.compareByName(c2);
        }
    },
    DATE {
        @Override
        public boolean areEqual(ConferenceInfo c1, ConferenceInfo c2) {
            return c1.compareByDate(c2);
        }
    },
    LOCATION {
        @Override
        public boolean areEqual(ConferenceInfo c1, ConferenceInfo c2) {
            return c1.compareByLocation(c2);
        }
    };

    public abstract boolean areEqual(ConferenceInfo c1, ConferenceInfo c2);
}