InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("WEB-INF/HR/Jasp.jrxml");


ByteArrayOutputStream baos =new ByteArrayOutputStream();
response.setContentType("application/pdf");

JasperDesign design = JRXmlLoader.load(reportStream);

JasperReport report = JasperCompileManager.compileReport(design);
JRResultSetDataSource jasperReports = new JRResultSetDataSource(rs);
JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), jasperReports);


net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfStream(print,baos);
response.setContentLength(baos.size());
ServletOutputStream out1 = response.getOutputStream();
baos.writeTo(out1);
out1.flush();
rs.close();
st.close();
conn.close();