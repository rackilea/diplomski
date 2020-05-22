String url = "http://domain.com/page?parameter1=value1&parameter2=value2";
List<NameValuePair> parameters = URLEncodedUtils.parse(new URI(url));
for (NameValuePair p : parameters) {
    System.out.println(p.getName());
    System.out.println(p.getValue());
}