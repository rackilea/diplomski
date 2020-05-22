import java.io.*;    
import javax.servlet.http.*;
import javax.servlet.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
// ... plus all the other libs you need

public class ExcelServlet extends HttpServlet {
  public void doGet (HttpServletRequest req,
                     HttpServletResponse res)
    throws ServletException, IOException
  {
    HSSFWorkbook book;
    // ...
    // fill the book
    // ...
    res.setContentType("application/vnd.ms-excel");
    book.write(res.getOutputStream());
    res.getOutputStream().close();
  }
}