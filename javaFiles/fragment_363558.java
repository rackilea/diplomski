// this is in my servlet
public void doGet(HttpServletRequest req, HttpServletResponse resp) 
{
   Collection<Circle> circles = // some logic here 
   req.setAttribute("circles", circles);
}