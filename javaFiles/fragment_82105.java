foo = fooService.get(id); //use id from pathvariable
redirectView = new RedirectView(foo.getCorrectUrl()); //set url to correct url, not that in path
redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY); //moved permanently
modelAndView = new ModelAndView(redirectView);
modelAndView.setViewName("myFoo.jsp");
return modelAndView;