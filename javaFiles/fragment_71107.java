URI uri = new URI("http", "clicks.pureleads.com","/c/E1oTzCqNzcgtN8YfNs5wg25lxQ7X8*PEqjqks**E|l9gsgSg6ZyKU7FdR0WkUDvIZ2jgG9hhb1qfSlUJpaojsCMystWBEfw6EacQ4K)zd6CtREq0PA68Uj4rPqLEsBgQdK6pgV88epNw3LF7S3X4erNQmaF26N)47Eb8H9O58bmMrEwGTBJ*avyzVCGxuyuaAoqBkOBafBru3i44S*oP74Wu4toNaTW3onZrpV9qsIqsMb3kC9J2s4RDStFqTAzH0VPlO)ZI0SWtJAchAt76suO2vTJdu6WVynplETGZD4I6DvNiQ1CSnQtSE0G2ing((",null);
    String url = uri.toString();
    URL serverAddress = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection();
    connection.setConnectTimeout(2000);
    connection.setReadTimeout(2000);
    connection.connect();

    InputStream inputStream = connection.getInputStream();

    String output = IOUtils.toString(inputStream);