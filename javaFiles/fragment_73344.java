int returnCode = client.executeMethod(method);
if(returnCode == 405 ) {
        System.out.println("The Options method is not implemented by this URI");
} else {
        Header[] header = method.getResponseHeaders();
        for(int i = 0; i < header.length; i++) {
             System.out.println(header[i].getName() + ": " + header[i].getValue());
        }
}