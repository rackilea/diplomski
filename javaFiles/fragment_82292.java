JTable orderResults = new JTable() {
    @Override
    public Class getColumnClass(int column) {
        // first 5 columns will be represented as an checkbox
        if(column <= 4){
            return Boolean.class;
        }

        // rest of them as a text
        return String.class;
    }
};