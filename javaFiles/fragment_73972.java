response.setContentType("application/ms-excel"); // or you can use text/csv
response.setHeader("Content-Disposition", "attachment; filename=output.csv"); 
try {
    // Write the header line
    OutputStream out = response.getOutputStream();
    String header = "EmployeeCode, Band\n";
    out.write(header.getBytes());
    // Write the content
    String line=new String(EmployeeCode+","+Band+"\n");
    out.write(line.toString().getBytes());
    out.flush();
} catch (Exception e) {
   log.error(e);
}