<%

 URL url = new URL("http://ddr.mobileok.kr/profile/DeviceProfile.do?mn=SCH-W420");
 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 connection.setRequestMethod("GET");
 connection.connect();
 InputStream stream = connection.getInputStream();
 // read input stream directly or via DOM or via SAX or whatever
%>