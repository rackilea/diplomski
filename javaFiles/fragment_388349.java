public JasperPrint loadReceipt(String reportName, String paymentId, String realPath) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        JasperReport report = null;
        JasperPrint print = null;

        try {
            if (jrReportMap == null) {
                jrReportMap = new HashMap<String, JasperReport>();
            }           

            if (jrReportMap.get(reportName) == null) {
                report = JasperCompileManager.compileReport(reportManager.load(reportName));
                jrReportMap.put(reportName, report);
                log.info(Logger.EVENT_SUCCESS, "--- Report Compilation done --- " + reportName);
            } else {
                report = jrReportMap.get(reportName);
                log.info(Logger.EVENT_SUCCESS, "--- Report already Compiled --- " + reportName);
            }

            params.put("paymentId", paymentId);
            params.put("realPath", realPath);

            try {
                Connection conn = reportDataSource.getConnection();
                print = JasperFillManager.fillReport(report, params, conn);
                conn.close();
            } catch (SQLException e) {
                System.err.println("--- SQL ERR - to get connection -----");
                log.error(Logger.EVENT_FAILURE, "--- Report already Compiled --- " + reportName);
                e.printStackTrace();
            }
        } catch (JRException e1) {
            log.error(Logger.EVENT_FAILURE, "Oops... Something wrong while rendering the report !!!");
            e1.printStackTrace();
        }
        return print;
    }