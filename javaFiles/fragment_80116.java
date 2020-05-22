public class DownloadPDF extends HttpServlet {

public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        //Extract some request parameters, fetch your data and generate your document

        String fileName = "<SomeFileName>.pdf";
        res.setContentType("application/pdf");
        res.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        writePDF(<SomeObjectData>, res.getOutputStream());
    }
}