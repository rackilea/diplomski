class MyTab {
    // I use constants or an enum to avoid typo errors
    public static final String COLUMN_1 = "col1";
    public static final String COLUMN_2 = "col2";
    public static final String COLUMN_3 = "col3";

    private String col1;
    private String col2;
    private String col3;

    public MyTab(String col1, String col2, String col3) {
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
    }

    public String getCol1() {
        return col1;
    }

    public String getCol2() {
        return col2;
    }

    public String getCol3() {
        return col3;
    }

    // you'll want an equals, haschCode and toString methods

}