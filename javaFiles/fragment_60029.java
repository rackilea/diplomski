public static void main(String[] args) throws Exception {

  StreamFactory factory = StreamFactory.newInstance();
  factory.load("C:\\Users\\PV5057094\\Demo_workspace\\XlsxMapper\\src\\main\\resources\\Employee.xml");

  BeanReader br = factory.createReader("EmployeeInfo",new File("C:\\Temp\\Soc\\textInput.txt"));
  BeanWriter out = factory.createWriter("EmployeeInfoCSV", new File("C:\\Temp\\Soc\\output.csv"));

  // write the column headers to the output file
  out.write("headers", null);

  Object record;
  while ((record=br.read())!=null) {
    out.write(record);
    System.out.println("Record Written:" + record.toString());
  }

  br.close();  // yes, also close the reader
  out.flush();
  out.close();
}