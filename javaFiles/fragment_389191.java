@RequestMapping("/myURL.json")
public ModelAndView myMethod(){
    ModelAndView modelAndView = new ModelAndView();
    List<MyClass> mylist = myService.getList();
    modelAndView.addObject("MyClassName", myList);
    return modelAndView;
}