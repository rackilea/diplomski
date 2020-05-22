import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        String contentType = null;

        if (fileName.endsWith("xls")) {
            contentType = "application/octet-stream";
        } else if (fileName.endsWith("pdf")) {
            contentType = "application/pdf";
        } else {
            throw new RuntimeException("File type not found");
        }

        byte[] file = getFileOnServer(fileName);

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setHeader("charset", "iso-8859-1");
        response.setContentType(contentType);
        response.setContentLength(file.length);
        response.setStatus(HttpServletResponse.SC_OK);

        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(file, 0, file.length);
            outputStream.flush();
            outputStream.close();
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private byte[] getFileOnServer(String fileName) {
        //implement your method to get the file in byte[]
        return null;
    }

}