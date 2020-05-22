protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors){
//get the id
int id = Integer.parseInt(request.getParameter("id"));

// get the object
Item item = dao.getItemById(id);
return  new ModelAndView(getFormView(), "item", item);
}