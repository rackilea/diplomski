public class JasperExampleServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

        try {
            JasperReport report = (JasperReport)JRLoader.loadObject("Your Jasper Path");
            Map parameters = new HashMap();
            parameters.put("foo", someParam1);
            parameters.put("bar", someParam2);

            Connection con = DriverManager.getConnection("Your DB Info");
            JasperPrint print = JasperFillManager.fillReport(report,parameters,con);

            // Output PDF to HTTP Response
            response.setContentType("application/pdf");
            JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
        } catch ( Exception e){
            e.printStackTrace();
        }
    }
}