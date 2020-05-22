FluentIterable.from(table.rowMap().values()).filter(new Predicate<Map<String, String>>() {
    @Override
    public boolean apply(Map<String, String> row) {
        return row.get("FirstName").contains("ab") || row.get("LastName").contains("an");
    }
});