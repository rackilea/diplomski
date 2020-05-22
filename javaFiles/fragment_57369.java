String query = "env.adapterName=DefaultAdapter"
    + "&env.systemName=DefaultSystem"
    + "&env.userId=admin"
    + "&env.progId=PerlHttpTest";
    + "&" + URLEncoder.encode(interopApiName, "UTF-8") + "=" + URLEncoder.encode(apiName, "UTF-8")
    + "&" + URLEncoder.encode(interopApiData, "UTF-8") + "=" + URLEncoder.encode(xmlData, "UTF-8");

URLConnection connection = new URL("http://hostname/interop/InteropHttpServlet").openConnection();
connection.setDoOutput(true); // Triggers POST.
connection.getOutputStream().write(query.getBytes("UTF-8"));

InputStream response = connection.getInputStream();
// ...