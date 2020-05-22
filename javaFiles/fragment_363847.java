protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = productService.list();
            request.setAttribute("products", products); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
}