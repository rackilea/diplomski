import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public byte[] export(final JasperPrint print) throws JRException {
    final Exporter exporter;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    boolean html = false;

    switch (getReportFormat()) {
        case HTML:
            exporter = new HtmlExporter();
            exporter.setExporterOutput(new SimpleHtmlExporterOutput(out));
            html = true;
            break;

        case CSV:
            exporter = new JRCsvExporter();
            break;

        case XML:
            exporter = new JRXmlExporter();
            break;

        case XLSX:
            exporter = new JRXlsxExporter();
            break;

        case PDF:
            exporter = new JRPdfExporter();
            break;

        default:
            throw new JRException("Unknown report format: " + getReportFormat().toString());
    }

    if (!html) {
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
    }

    exporter.setExporterInput(new SimpleExporterInput(print));
    exporter.exportReport();

    return out.toByteArray();
}