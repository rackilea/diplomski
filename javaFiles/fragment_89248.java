String url = "http://www.website.com/search?productId=1500";

List<NameValuePair> paramsList = URLEncodedUtils.parse(new URI(url),"utf-8");
for (NameValuePair parameter : paramsList)
    if (parameter.getName().equals("productId"))
        System.out.println(parameter.getValue());