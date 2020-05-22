@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String downloadKey = request.getParameter("key");
        CertificadoModel certificadoModel = (CertificadoModel) request.getSession().getAttribute(downloadKey);
        request.getSession().removeAttribute(downloadKey);

        // ...

        response.reset();
        response.setContentType("application/x-pkcs12"); 
        response.setContentLength(contentLength); 
        response.setHeader("Content-Disposition", "attachment; filename=\"" + certificadoModel.getUsername() + ".p12" + "\""); 
        keyStore.store(response.getOutputStream(), certificadoModel.getPassword().toCharArray());
    }

}