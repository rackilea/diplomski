URL urlGetToken = new URL("http://<host>:<port>/webhdfs/v1/?op=GETDELEGATIONTOKEN") ;
HttpURLConnection cnxGetToken =(HttpURLConnection) urlGetToken.openConnection() ;
BufferedReader httpMessage = new BufferedReader( new InputStreamReader(cnxGetToken.getInputStream()), 1024) ;
Pattern regexHasToken =Pattern.compile("urlString[\": ]+(.[^\" ]+)") ;
String httpMessageLine ;
while ( (httpMessageLine =httpMessage.readLine()) != null)
{ Matcher regexToken =regexHasToken.matcher(httpMessageLine) ;
  if (regexToken.find())
  { System.out.println("Use that template: http://<Host>:<Port>/webhdfs/v1%AbsPath%?delegation=" +regexToken.group(1) +"&op=...") ; }
}
httpMessage.close() ;