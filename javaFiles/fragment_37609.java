public class DownloadCsvServlet extends HttpServlet {

protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    final File file = new File("/tmp/data.csv");

    response.setContentType("text/csv");

    response.setHeader("Content-Disposition",
            "attachment; filename=" + file.getName());

    final BufferedReader br = new BufferedReader(new FileReader(file));
    try {
        String line;
        while ((line = br.readLine()) != null) {
            response.getWriter().write(line + "\n");
        }
    } finally {
        br.close();
    }
}

}