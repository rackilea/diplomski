URL codeBase = getCodeBase();
URL servletURL = new URL(codeBase.getProtocol(), codeBase.getHost(), codeBase.getPort(), "/myServlet");

// assumes protocol is http, could be https
HttpURLConnection conn = (HttpURLConnection)servletURL.openConnection();
conn.setDoOutput(true);
conn.setRequestMethod("POST");

PrintWriter out = new PrintWriter(conn.openOutputStream());
out.println("hello world");
out.close();

System.out.println(conn.getResponseCode());