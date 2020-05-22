@RequestMapping(value = "/filteredCSV.json")
@ResponseBody
public WebserviceResponse<?>filteredCSV(HttpRequest request){
    String date = request.getParameter('date');
    // Convert date if not 'null' here, and so on
}