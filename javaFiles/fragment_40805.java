package com.org;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.data.ConnectionInfoKind;
import com.crystaldecisions.sdk.occa.report.data.IConnectionInfo;
import com.crystaldecisions.sdk.occa.report.data.ITable;
import com.crystaldecisions.sdk.occa.report.exportoptions.ReportExportFormat;
import com.crystaldecisions.sdk.occa.report.lib.PropertyBag;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;

public class YetAnotherReader {

    public static void main(String[] args) {
        try {
            //Overwrite any existing properties with updated values.
            //information Oracle database
            String DBUSERNAME = "user";
            String DBPASSWORD = "password";
            String SERVERNAME = "server";
            String PORT = "1521";
            String DATABASE_NAME = "databaseName"; // SID or Instance
            String URI = "!oracle.jdbc.driver.OracleDriver!jdbc:oracle:thin:{userid}/{password}@" + SERVERNAME + ":" + PORT + "/" + DATABASE_NAME;  //1521/ or :1521
            String DATABASE_DLL = "crdb_jdbc.dll";
            //end

            String report_name = "C:\\myReport.rpt";
            String exportFileName = "C:\\fileName.pdf";
            ReportClientDocument clientDoc = new ReportClientDocument();
            clientDoc.open(report_name, ReportExportFormat._PDF);

            // Obtain collection of tables from this database controller.
            ITable table = clientDoc.getDatabaseController().getDatabase().getTables().getTable(0);

            IConnectionInfo connectionInfo = table.getConnectionInfo();
            PropertyBag propertyBag = connectionInfo.getAttributes();
            propertyBag.clear();

            //Overwrite any existing properties with updated values.
            propertyBag.put("Trusted_Connection", "false");
            propertyBag.put("Server Name", SERVERNAME); //Optional property.
            propertyBag.put("Database Name", DATABASE_NAME);
            propertyBag.put("Server Type", "JDBC (JNDI)");
            propertyBag.put("URI", URI);
            propertyBag.put("Use JDBC", "true");
            propertyBag.put("Database DLL", DATABASE_DLL);
            connectionInfo.setAttributes(propertyBag);

            //Set database username and password.
            //NOTE: Even if these the username and password properties don't change when switching databases, the 
            //database password is *not* saved in the report and must be set at runtime if the database is secured.  
            connectionInfo.setUserName(DBUSERNAME);
            connectionInfo.setPassword(DBPASSWORD);
            connectionInfo.setKind(ConnectionInfoKind.SQL);

            table.setConnectionInfo(connectionInfo);
            //Update old table in the report with the new table.
            clientDoc.getDatabaseController().setTableLocation(table, table);

            clientDoc.getDataDefController().getParameterFieldController().setCurrentValue("", "pk_id", 14);
            //Writing into PDF file
            ByteArrayInputStream bais = (ByteArrayInputStream) clientDoc.getPrintOutputController().export(ReportExportFormat.PDF);
            int size = bais.available();
            byte[] barray = new byte[size];
            FileOutputStream fos = new FileOutputStream(new File(exportFileName));
            ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
            int bytes = bais.read(barray, 0, size);
            baos.write(barray, 0, bytes);
            baos.writeTo(fos);
            clientDoc.close();
            bais.close();
            baos.close();
            fos.close();
            //dbConn.close();

        } catch (ReportSDKException ex) {
            System.out.println("ReportSDKException" + ex);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        }

    }

}