public void createRoadReport (List <StatisticsOnPassengerTrainByMonth> passsenger, List<StatisticsOnCommuterTrainByMonth> commuter, List<StatisticsOnFreightTrainByMonth> freight, String dateReport) throws JRException{
    List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();

    for (int i = 0; i < 3; i++) {
        JRBeanCollectionDataSource passengerDataSource = new JRBeanCollectionDataSource(passsenger);
        JRBeanCollectionDataSource commuterDataSource = new JRBeanCollectionDataSource(commuter);
        JRBeanCollectionDataSource freightDataSource  = new JRBeanCollectionDataSource(freight);

        Map <String, Object> parametr = new HashMap<String, Object>();
        parametr.put("PassengerDataSource", passengerDataSource);
        parametr.put("CommuterDataSource", commuterDataSource);
        parametr.put("FreightDataSource", freightDataSource);
        parametr.put("date", dateReport);
        switch (i) {
        case 0:
            jasperPrintDeparture = JasperFillManager.fillReport((FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReportRoadDeparture.jasper")), parametr, new JREmptyDataSource());
            jasperPrintList.add(jasperPrintDeparture);
        break;
        case 1:
            jasperPrintTracking = JasperFillManager.fillReport((FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReportRoadTracking.jasper")), parametr, new JREmptyDataSource());
            jasperPrintList.add(jasperPrintTracking);
        break;
        case 2:
            jasperPrintArrival = JasperFillManager.fillReport((FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ReportRoadArrival.jasper")), parametr, new JREmptyDataSource());
            jasperPrintList.add(jasperPrintArrival);
        break;
        }
    }

        //multipageLinking(jasperPrintDeparture, jasperPrintTracking);
        //JasperExportManager.exportReportToPdfFile(jasperPrintArrival, FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report.pdf"));
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList)); //Set as export input my list with JasperPrint s
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report.pdf"))); //or any other out streaam
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true); //add this so your bookmarks work, you may set other parameters
        exporter.setConfiguration(configuration);
        exporter.exportReport();

}