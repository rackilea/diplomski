public ModelAndView loadPageView(ModelMap model) {
TestCheck o = new TestCheck();
model.addAttributeA("testCheck", o);
// your code goes here
return new ModelAndView("...");
}