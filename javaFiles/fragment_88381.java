public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {           

     List<Category> catList = db.getCategory();           
     List<Product> proList = db.getProduct();           

     request.setAttribute("proList", proList);      
     request.setAttribute("catList ", catList );      
     return mapping.findForward("success");  
}