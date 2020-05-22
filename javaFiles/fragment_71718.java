PrintRequestAttributeSet printRequestAttrs = new HashPrintRequestAttributeSet();
printRequestAttrs.add(new PrinterResolution(600, 600, ResolutionSyntax.DPI)); // this resolution solved the problem
JRPrintServiceExporter exporter = new JRPrintServiceExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, report);
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttrs);
exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
exporter.exportReport();