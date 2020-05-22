public static void statusUpdateTest(String field_Name, String field_Value) throws Throwable {


    Fillo fillo = new Fillo();
    Connection connection = null;
    try {
        String excelPath = "C:\\Book\\Test.xlsx";
        connection = fillo.getConnection(excelPath);
        String strQuery = "Update Sheet1 Set Results='"+field_Value+"' where ID='"+field_Name+"'";
        connection.executeUpdate(strQuery);
        connection.close();
    } catch (Exception e) {
        throw new Exception(ExceptionUtils.getFullStackTrace(e));
    } finally {
        Objects.requireNonNull(connection).close();
    }
}