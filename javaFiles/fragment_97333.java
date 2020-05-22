@RequestMapping(value = "/", method = RequestMethod.GET)
public ModelAndView returnHtmlPage(){
    ModelAndView model = new ModelAndView("page");
                /* here you can put anything in 'model' object that you
                   want to use them in your page.jsp file */
    return model;
}