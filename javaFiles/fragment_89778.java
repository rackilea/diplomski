try {
        trustAllCertificates(); // For testing only

        reportFileServiceAddress = new URL("http://my.host.name/ptsqamt/Maintain/services/reports/2010/09/ReportFileService.svc");
        reportServicesAddress = new URL("http://my.host.name/ptsqamt/Maintain/services/reports/2010/09/ReportServices.svc");
    } catch (MalformedURLException e) {

        e.printStackTrace();
    }

    ReportServices rsProxy = connectToReportServices(reportServicesAddress);
    ReportFileService rfsProxy = connectToReportFileService(reportFileServiceAddress);