@RequestMapping (value="/services/SayHello2Me")
@ResponseBody
public String SayHello2Me(HttpServletRequest request) throws Exception {

String input = (String) request.getParameter("name");
String output = "hello " + input + " :)";
JSONObject outputJsonObj = new JSONObject();
outputJsonObj.put("output", output);

return outputJsonObj.toString();
}