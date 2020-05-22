try {
    SQLContainer deleteContainer = new SQLContainer(new TableQuery("tbl_grade", connectionPool));
    RowId itemID = new RowId(new Integer[] { 10 });
    deleteContainer.removeItem(itemID);
    deleteContainer.commit();
} catch (SQLException ex) {
    ex.printStackTrace();
}