import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        c = getConnection();
        ps = buildDBRequest(request);
        rs = ps.executeQuery();
        Result result = ResultSupport.toResult(rs);
        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("/showResult.jsp");
        rd.forward(request, response);
    } catch(SQLException ex) {
        throw new ServletException(ex);
    } finally {
        close(c, ps, rs);
    }
}