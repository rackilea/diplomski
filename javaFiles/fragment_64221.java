class QueryResult {

        Object count; // change to Object;

        int getCount() {
            // do the error handling
            if (count instanceof Integer) {
                return ((Integer) count);
            } else {
                return 0;
            }
        }
    }