import com.crystaldecisions.reports.sdk.DatabaseController;
import com.crystaldecisions.reports.sdk.ReportClientDocument;
import com.crystaldecisions.reports.sdk.ParameterFieldController;
import com.crystaldecisions.sdk.occa.report.data.IConnectionInfo;
import com.crystaldecisions.sdk.occa.report.exportoptions.ExportOptions;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;
public class Test {
public static void main(String args[]) throws ReportSDKException, SQLException,      FileNotFoundException, IOException{
try{

ReportClientDocument reportClientDoc = new ReportClientDocument();

ParameterFieldController paramController = reportClientDoc.getDataDefController().getParameterFieldController();
paramController.setCurrentValue("","P_DP",new Integer(22));

reportClientDoc.open("Report.rpt",0);


//Here I was calling switch database code 
 ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream)reportClientDoc.getReportSource().export(ReportExportFormat.PDF);
 IOUtils.copy(byteArrayInputStream, new FileOutputStream("new.pdf"));

 reportClientDoc.close();

 }
}