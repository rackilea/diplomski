@RequestMapping(value = "/files", method = RequestMethod.GET)
public void saveTxtFile(HttpServletResponse response) throws IOException {

    String yourXmlFileInAString;
    response.setContentType("application/xml");
    response.setHeader("Content-Disposition", "attachment;filename=thisIsTheFileName.xml");

    BufferedReader br = new BufferedReader(new FileReader(new File(YourFile.xml)));
    String line;
    StringBuilder sb = new StringBuilder();

    while((line=br.readLine())!= null){
        sb.append(line);
    }

    yourXmlFileInAString  = sb.toString();

    ServletOutputStream outStream = response.getOutputStream();
    outStream.println(yourXmlFileInAString);
    outStream.flush();
    outStream.close();
}