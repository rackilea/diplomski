public static void main(String[] args) {

     String reportPath = "C:/Users/Sadagopan/Documents/report3.jasper";
     Map<String, Object> params = new HashMap<String, Object>();
     Connection connection;

    try {

       // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","password");

        System.out.println("Filling report...");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:/Users/Sadagopan/Documents/sample.html"); 
        JasperViewer.viewReport(jasperPrint, false);
        connection.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }
}