public static void main(String[] args) throws Exception {

    StreamFactory factory = StreamFactory.newInstance();
    factory.load("C:\\Users\\PV5057094\\Demo_workspace\\XlsxMapper\\src\\main\\resources\\Employee.xml");

    BeanReader br = factory.createReader("EmployeeInfo",new File("C:\\Temp\\Soc\\textInput.txt"));
    BeanWriter out = factory.createWriter("EmployeeInfoCSV", new File("C:\\Temp\\Soc\\output.csv"));

    boolean columnHeadersWritten = false;
    Object record;
    while ((record=br.read())!=null) {

      if (!columnHeadersWritten) {
        final Employee employee = (Employee) record;
        final HeaderColumns headerColumns = new HeaderColumns();
        for (int i = 0; i < employee.getErrorCount(); i++) {
          headerColumns.addErrorColumns(new ErrorColumns());
        }
        out.write(headerColumns);
        columnHeadersWritten = true;
      }

      out.write(record);
      System.out.println("Record Written:" + record.toString());
    }

    in.close();
    out.flush();
    out.close();
}