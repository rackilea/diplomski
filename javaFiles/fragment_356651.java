PrintWriter writer = res.getWriter();
String content = "10 141 nahush123 01";
URL url = new URL("http://52.220.37.12:8080/servers/servers");
System.out.println(url.toString());
HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
httpCon.setDoInput(true);
httpCon.setDoOutput(true);
httpCon.setRequestMethod("POST");
httpCon.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");

OutputStream os = httpCon.getOutputStream();
BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
out.write(content);
out.flush();
//br = BufferReader(out);
System.out.println(httpCon.getResponseCode());
System.out.println(httpCon.getResponseMessage());
writer.println(httpCon.getResponseMessage());


//httpCon.connect();
BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
//reading response
//String resp;
//if(br != null){
content = br.readLine();
//}
System.out.println(content);
writer.println(content);
writer.flush();
writer.close();
out.close();
os.close();