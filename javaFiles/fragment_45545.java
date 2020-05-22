protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           // response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                /*
                 * TODO output your page here. You may use following sample code.
                 */
               String a=null;
               a.toString();

            }
            catch(Exception e)
            {
                throw new ServletException(e);
            }

            finally {            
                //dont write out.close();
            }
        }