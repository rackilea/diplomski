public static QuerySelector forName(String query) {
    for (QuerySelector param : QuerySelector.values()) {
        if (query.equals(param.toString()))) {
            return param;
        }
    }
    return null;
}