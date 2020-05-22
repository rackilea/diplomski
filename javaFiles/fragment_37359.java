String cc=req.getParameter("country");
   String ln=req.getParameter("language");
   Locale l=null;
   if(cc==null)
     l=new Locale("en","US");
   else
     l=new Locale(ln,cc);

   ResourceBundle rb=ResourceBundle.getBundle("ApplicationResources",l);
   req.setAttribute("resource", rb);