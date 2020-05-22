Document doc = Jsoup.parse(html);

Element acctname = doc.select("input[name=acctname]").first();
Element pswrd = doc.select("input[name=pswrd]").first();

System.out.println(acctname);
System.out.println(pswrd);