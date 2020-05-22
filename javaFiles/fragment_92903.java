URLConnection connection = new URL(searchQuery).openConnection();
connection.setFollowRedirects(true);
connection.setRequestProperty("User-Agent", 
      "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:10.0.2) Gecko/20100101 Firefox/10.0.2");
connection.connect();
InputStream response = connection.getInputStream();
...