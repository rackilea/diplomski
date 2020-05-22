InputStream in = channel.getInputStream();
[...]
channel.disconnect();
session.disconnect();
[...]
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
for (String line; (line = reader.readLine()) != null;){