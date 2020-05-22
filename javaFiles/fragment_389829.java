try {
            JasperPrint print = JasperFillManager.fillReport(
                    fileName,
                    hm,
                    new JREmptyDataSource());
            JRExporter exporter =
            new net.sf.jasperreports.engine.export.JRPdfExporter();
            exporter.setParameter(
            JRExporterParameter.OUTPUT_FILE_NAME,
            outFileName);
            exporter.setParameter(
            JRExporterParameter.JASPER_PRINT, print);
            JasperExportManager.exportReportToPdfFile(print, outFileName);
            print = null;
            exporter = null;
            //JasperViewer.viewReport(print,false);
        } catch (Exception e) {
            e.printStackTrace();
        }