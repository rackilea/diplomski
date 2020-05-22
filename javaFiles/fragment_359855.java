package com.affno.etender.frontend;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;
import com.affno.util.proxool.ProxoolConnection;

public class ActDownloadDocZip extends Action {
    static Logger logger = Logger.getLogger(ActDownloadDocZip.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String realPath = getServlet().getServletContext().getRealPath(
                "/WEB-INF/log4jConfiguration.xml");
        DOMConfigurator.configure(realPath);
        logger.info("In ActDownloadDocZip....");

        ActionForward forward = null;
        HttpSession session = request.getSession();

        // get a db connection
        Connection conn = null;

        String[][] nameFile = null;

        String tenderNo = "";

        ////
        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;

        MessageResources messages = MessageResources.getMessageResources("resources.Upload");
        String dirzip = messages.getMessage("save.dir");
        tenderNo = request.getParameter("tenderNo").trim();
        String zipFolderName =tenderNo + ".zip";
        String filepathzipped = dirzip + zipFolderName;

        try {
            conn = ProxoolConnection.getProxoolConnectionSLT();

            fos = new FileOutputStream(filepathzipped);
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));

            ILoadTenders ld = new LoadTenders();
            nameFile = ld.getPdfFileListToTender(conn, tenderNo);

            for (int i = 0; i < nameFile.length; i++){
                File input = new File(nameFile[i][1].trim());
                fis = new FileInputStream(input);
                ZipEntry ze = new ZipEntry(input.getName());
                System.out.println("Zipping the file: "+input.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[4*1024];
                int size = 0;
                while((size = fis.read(tmp)) != -1){
                    zipOut.write(tmp, 0, size);
                }
                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            System.out.println("Done... Zipped the files...");
            //zip created

            //downloading the zip
            File file = new File(filepathzipped);
            if(!file.exists()){
                System.out.println("file not found");
            }
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" + zipFolderName + "\"");

            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0){
               out.write(buffer, 0, length);
            }
            in.close();
            out.flush();    
        }
        ////
         catch (SQLException e) {
            System.out.println("actDownloadDocZip " + e);
            logger.fatal(e.getMessage());
        } catch (Exception e) {
            System.out.println("actDownloadDocZip1 " + e);
            logger.fatal(e.getMessage());
        } finally {
            if (conn != null) {
                ProxoolConnection.closeProxoolConnectionSLT(conn);
            }
        }

        forward = mapping.findForward("publicdashboard");
        /*
         * if (forward != null) { forward = new ActionForward(forward.getPath()
         * +"servlet/DownloadServlet?" + zipFile, true); }
         */
        return forward;
    }
}