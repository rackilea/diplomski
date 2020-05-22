import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

(...)

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (ServletFileUpload.isMultipartContent(request)) {
            handleMultiPartContent(request);
        }
    }

    private void handleMultiPartContent(HttpServletRequest request) {

        ServletFileUpload upload = new ServletFileUpload();
        upload.setFileSizeMax(2097152); // 2 Mb
        try {
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                if (!item.isFormField()) {
                    File tempFile = saveFile(item);
                    // process the file
                }
            }
        }
        catch (FileUploadException e) {
            LOG.debug("Error uploading file", e);
        }
        catch (IOException e) {
            LOG.debug("Error uploading file", e);
        }
    }

    private File saveFile(FileItemStream item) {

        InputStream in = null;
        OutputStream out = null;
        try {
            in = item.openStream();
            File tmpFile = File.createTempFile("tmp_upload", null);
            tmpFile.deleteOnExit();
            out = new FileOutputStream(tmpFile);
            long bytes = 0;
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
                bytes += len;
            }
            LOG.debug(String.format("Saved %s bytes to %s ", bytes, tmpFile.getCanonicalPath()));
            return tmpFile;
        }
        catch (IOException e) {

            LOG.debug("Could not save file", e);
            Throwable cause = e.getCause();
            if (cause instanceof FileSizeLimitExceededException) {
                LOG.debug("File too large", e);
            }
            else {
                LOG.debug("Technical error", e);
            }
            return null;
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e) {
                LOG.debug("Could not close stream", e);
            }
        }
    }