public class DirectoryServlet extends HttpServlet {
    private static final File BASE_DIR = new File("D://");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getParameter("path");
        File file;
        if (path == null || path.isEmpty()) {
            file = BASE_DIR;
        } else {
            file = new File(BASE_DIR, path);
        }
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            traverse(out, file, "");
        }
    }

    private static void traverse(PrintWriter out, File parentNode,
            String leftIndent) {
        out.println(leftIndent + "{");
        String indent = leftIndent + "    ";
        out.print(indent + "\"name\":\""
                + parentNode.getName() + "\"");
        if (!parentNode.isDirectory()) {
            out.println();
        } else {
            array(out, parentNode.listFiles(file -> file.isFile()), "files", indent);
            array(out, parentNode.listFiles(file -> file.isDirectory()), "folders", indent);
        }
        out.print(leftIndent + "}");
    }

    private static void array(PrintWriter out, File[] files, String attr,
            String leftIndent) {
        if (files == null || files.length == 0) {
            out.println();
        } else {
            out.println(",");
            out.print(leftIndent + "\"" + attr + "\":[");
            String indent = leftIndent + "    ";
            boolean first = true;
            for (File file: files)  {
                if (first) {
                    out.println();
                    first = false;
                } else {
                    out.println(",");
                }
                traverse(out, file, indent);
            }
            out.print("]");
        }
    }

    @Override
    public String getServletInfo() {
        return "JSON directory structure";
    }
}