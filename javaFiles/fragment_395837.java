@RequestMapping(value = "/loadData", method = RequestMethod.GET) 
public @ResponseBody String loadData(@ModelAttribute("SpringWeb")Context context, ModelMap model) {
/** here i am assuming context.getWeather() and context.getCompanions() returns string or at least values you can convert to string using toString() method. If you need to convert them to string then you will need to change the code to context.getWeather().toString() + context.getCompanions().toString() **/

  return context.getWeather() + context.getCompanions();
}