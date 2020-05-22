public static class JasperReportsWorker extends SwingWorker<JasperReport, JasperReport> {

    @Override
    protected JasperReport doInBackground() throws Exception {
        JasperReport report = null;
        try {
            String reportquery = "Select * from invoices ";
            JasperDesign jasperdesign = JRXmlLoader.load("StatementReport.jrxml");
            JRDesignQuery designquery = new JRDesignQuery();
            designquery.setText(reportquery);
            jasperdesign.setQuery(designquery);
            report = JasperCompileManager.compileReport(jasperdesign);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return report;
    }

}