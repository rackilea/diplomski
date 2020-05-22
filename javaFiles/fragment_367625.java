package q46617008;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class JasperExample
{

    private Map< String, Object > parameters;

    private String filePath = "C:\\Path\\To\\Your\\Worksheet.jrxml";

    public JasperExample( ) {

        parameters = new HashMap<>( );
        // Define your locale or set it as a parameter
        parameters.put( JRParameter.REPORT_LOCALE, new Locale( "pt", "BR" ) );
        parameters.put( "Alphabets", WorksheetExample.alphabets );
        parameters.put( "Books", WorksheetExample.books );
    }

    public void exportPDF( WorksheetExample w ) throws Exception
    {

        JRDataSource reportDataSource = new JREmptyDataSource( 1 );

        JasperReport report = JasperCompileManager.compileReport( filePath );

        JasperPrint jasperPrint = JasperFillManager.fillReport( report, parameters, reportDataSource );

        JRPdfExporter exporter = new JRPdfExporter( );
        exporter.setExporterInput( new SimpleExporterInput( jasperPrint ) );
        exporter.setExporterOutput( new SimpleOutputStreamExporterOutput( Files.newOutputStream( w.file, StandardOpenOption.CREATE ) ) );

        exporter.exportReport( );
    }

    public void exportXLSX( WorksheetExample w ) throws Exception
    {

        JRDataSource reportDataSource = new JREmptyDataSource( 1 );

        JasperReport report = JasperCompileManager.compileReport( filePath );

        JasperPrint jasperPrint = JasperFillManager.fillReport( report, parameters, reportDataSource );

        JRXlsxExporter exporter = new JRXlsxExporter( );
        exporter.setExporterInput( new SimpleExporterInput( jasperPrint ) );
        exporter.setExporterOutput( new SimpleOutputStreamExporterOutput( Files.newOutputStream( w.file, StandardOpenOption.CREATE ) ) );

        exporter.exportReport( );
    }

}