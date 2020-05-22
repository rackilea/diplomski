public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    try {
        int len = req.getContentLength();
        byte[] input = new byte[len];

        ServletInputStream sin = req.getInputStream();
        int c, count = 0 ;
        while ((c = sin.read(input, count, input.length-count)) != -1) {
            count +=c;
        }

        sin.close();        
        String inString = new String(input);
        int index = inString.indexOf("=");            
        String value = inString.substring(index + 1);                        
        inputStream = URLDecoder.decode(value, "UTF-8");         

    } catch (IOException e) {

    }
    responseWriter(resp);
}//end of requestReader 

public void responseWriter(HttpServletResponse resp) {
    try{
            resp.setStatus(HttpServletResponse.SC_OK);
            OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream());
            writer.write("Working");    
            writer.flush();
            writer.close();               

    } catch (IOException e) {

    }


}//end of responseWriter