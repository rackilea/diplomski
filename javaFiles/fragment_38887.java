public static List<File> Search(String path, SearchType search, String... searchArgs) {
    if (search == SearchType.REGEX) {
        if (searchArgs.length != 1) {
            throw new IllegalArgumentException("Improper number of arguments for regex search: Expected 1, got " + searchArgs.length);
        }

        //Do the search
    }

    if (search == SearchType.DEFAULT) {
        if (searchArgs.length != 0) {
            throw new IllegalArgumentException("Improper number of arguments for default search: Expected 0, got " + searchArgs.length);
        }

        //Do the search
    }
}