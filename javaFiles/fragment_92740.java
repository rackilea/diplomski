Column<YOURDATAOBJECT, String> nameColumn = new Column<YOURDATAOBJECT, String>(
        new TextCell()) {
    @Override
    public String getValue(YOURDATAOBJECT object) {
        return object.getYOURCOLUMDATA();
    }
};
this.addColumn(nameColumn, YOURHEADERNAME);