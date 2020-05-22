class UrlTest {
        public static void main(String[] args) throws java.io.UnsupportedEncodingException {
                String url = "http://example.com/%20foo";

                if(url.equals(java.net.URLDecoder.decode(url, "UTF-8"))) {
                        System.out.println("URL didn't contain encoded parts.");
                } else {
                        System.out.println("URL contained encoded parts.");                                                                                                                                
                }                                                                                                                                                                                          
        }                                                                                                                                                                                                  
}