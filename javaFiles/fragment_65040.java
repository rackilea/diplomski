HttpSession session = req.getSession(false);

if (session != null && session.getAttribute(ManageCustomerMbeans.AUTH_KEY) != null) {
    chain.doFilter(req, resp);
} else {
    resp.sendRedirect(req.getContextPath() + "/login.jsp");
}