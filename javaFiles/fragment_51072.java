public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = -6988332690679764038L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {

        String path = "/home/tomcat/engage/media/";
        String user = "";

        if (ServletFileUpload.isMultipartContent(request)) {

            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            boolean gotPath = false;

            String message = "";
            String media_category = "";

            StringBuilder sb = new StringBuilder();
            sb.append(Shared.getTimeStamp() + ": Uploading med files to category - ");

            try {
                FileItemIterator it = upload.getItemIterator(request);

                while (it.hasNext()) {
                    FileItemStream item = it.next();

                    //message += item.getFieldName() + ": ";

                    if (item.isFormField()) {
                        if (item.getFieldName().equals("MediaCategory")) {
                            media_category = Streams.asString(item.openStream());
                            path += media_category;

                            gotPath = true;

                            message += path + System.lineSeparator();

                        } else if (item.getFieldName().equals("UserName")) {

                            user += Streams.asString(item.openStream());

                        }
                    } else {
                        if (gotPath) {
                            String fileout = path + "/" + item.getName();

                            message += fileout + System.lineSeparator();

                            InputStream input = null;
                            OutputStream output = null;

                            try {
                                output = new FileOutputStream(new File(fileout));

                                input = item.openStream();

                                byte[] buffer = new byte[256];
                                int count;

                                while ((count = input.read(buffer)) > 0) {
                                    output.write(buffer, 0, count);
                                }

                            } finally {
                                input.close();
                                output.close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                response.sendRedirect("Error on item: " + e.getLocalizedMessage());
            }

            response.setStatus(HttpServletResponse.SC_CREATED);

            //response.getWriter().print(message);

            sb.append(message + System.lineSeparator());
            Shared.writeUserLog(user, sb.toString());

        } else {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, 
                    "Unsupported media type...");
        }

    }
}