// codes 

GetMethod method      = new GetMethod(url);

// passing the credentials
HttpClient httpClient = new HttpClient();
httpClient.getState().setCredentials(org.apache.commons.httpclient.auth.AuthScope.ANY, new org.apache.commons.httpclient.NTCredentials(username,pass,url,domain));

Document doc = null; // org.jsoup.nodes.Document

if( http.executeMethod(method)==200){
    doc = Jsoup.parse(new DataInputStream(method.getResponseBodyAsStream()), "UTF-8", url);
}

// codes