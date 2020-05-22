URL url = new URL("http://www.nseindia.com/content/equities/niftysparks.htm");
Document doc = Jsoup.parse(url, 3000);

Element table = doc.select("table[class=niftyd]").first();

Iterator<Element> ite = table.select("td[width=65]").iterator();

ite.next(); // first one is image, skip it

System.out.println("Value 1: " + ite.next().text());
System.out.println("Value 2: " + ite.next().text());
System.out.println("Value 3: " + ite.next().text());
System.out.println("Value 4: " + ite.next().text());