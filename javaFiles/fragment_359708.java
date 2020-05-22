// without setting your created keystore
// a sun.security.validator.ValidatorException will be thrown
System.setProperty("javax.net.ssl.trustStore", "your_keystore.jks");
String url = "https://parents.mtsd.k12.nj.us";
Document doc = Jsoup.connect(url).get();
System.out.println("doc = " + doc.text());