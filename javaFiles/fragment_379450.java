public String getRequestPayload(HttpServletRequest req) {
    StringBuilder buffer = new StringBuilder();
    BufferedReader reader;
    String data = "";
    try {
        reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        data = buffer.toString();   
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return data;
}