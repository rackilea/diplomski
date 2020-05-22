@namespace("com.test.foo")
protocol PairStore {

    /** Still need to define this record, but define it in the existing namespace. */
    @namespace("com.test.bar")
    record Pair {
        string item1;
        string item2;
    }

    record Registration {
        /** And this is how you refer to that record. */
        com.test.bar.Pair inputPair;
        com.test.bar.Pair outputPair;
        string indexURI;
    }
}