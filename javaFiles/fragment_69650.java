reqest.getSession().setAttribute("udername","Elbek");
    //later 
    reqest.getSession().removeAttribute("udername");

   //destroy it
   reqest.getSession().invalidate();