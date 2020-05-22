WebClient htmlunit = new WebClient();
HtmlPage page = htmlunit.getPage("http://www.google.com");
page = page.executeJavaScript("<JS code here>").getNewPage(); 

//manipulate the JS code and re-excute
page =  page.executeJavaScript("<manipulated JS code here>").getNewPage();

//manipulate the JS code and re-excute
page =  page.executeJavaScript("<manipulated JS code here>").getNewPage();