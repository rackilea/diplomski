public class MyFilter implements Filter {

    private byte[] my_gzipped_page = ....

    public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain) throws IOException, ServletException {

        if (req instanceof HttpServletRequest) {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            String ae = request.getHeader("accept-encoding");

            if (ae != null && ae.indexOf("gzip") != -1) {

                response.addHeader("Content-Length",
                    Integer.toString(my_gzipped_page.length)); 
                response.addHeader("Content-Encoding", "gzip");

                OutputStream output = response.getOutputStream();
                output.write(my_gzipped_page);
                output.flush();
                output.close();

                return;

            } else ...

        }
    }
    ...
}