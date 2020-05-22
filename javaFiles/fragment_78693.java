enum Title {
    ...

    public static Title fromString(String title) {
        if (title != null) {
            for (Title t : Title.values()) {
                if (t.toString().equals(title)) {
                    return t;
                }
            }
        }
        return null;
    }
}