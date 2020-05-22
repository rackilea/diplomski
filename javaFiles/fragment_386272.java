@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.list();
        request.setAttribute("products", products); // Will be available as ${products} in JSP
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    }

}