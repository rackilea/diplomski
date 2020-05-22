// create pdf
if(action != null && action.equals("pdf")) {
    String reqURL = request.getRequestURL().toString();
    String reqQuery = "id=" + bomModuleId+ "&action=pdf";
    String folderName = "doonot";
    GeneratePDF obj = new GeneratePDF();
    obj.genrateCmd(reqURL, "xxx", "xxx", reqQuery, folderName, "10.07.2012");  
}