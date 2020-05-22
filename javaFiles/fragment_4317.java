URL server = new URL(url); //works for https and not for http, i needed https in  my case.
Authenticator.setDefault((new MyAuthenticator()));

URLConnection connection = (URLConnection)server.openConnection();
connection.connect();
InputStream is = connection.getInputStream();
.... //write code to fetch inputstream