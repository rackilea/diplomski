public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Book book) throws Exception {
    /**
      * Book object has not been added to the model
      */ 
    ModelMap modelMap = new ModelMap();
    modelMap.addAttribute("bookList", bookDAO.listBooks(book);

    return new ModelAndView("bookForm", modelMap);
}