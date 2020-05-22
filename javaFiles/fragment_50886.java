@Service
public class ExportarReportPdfService {

    public byte[] exportar(List<JasperPrint> jasperPrintList)  {

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));

        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        [OMITED CODE]

        try {
            exporter.exportReport();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CriacaoReportException("Erro ao exportar para PDF");
        }
    }
}