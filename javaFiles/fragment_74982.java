String content="<HTML>"
    +"<HEAD>"
    +"  <meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\">"
    +"  <TITLE>title</TITLE>"
    +"</HEAD>"
    +"<BODY>"
    +"<div id=\"test\">hello world!</div>"
    +"</BODY>"
    +"</HTML>"
    ;

Document doc = Jsoup.parse(content);
Element test = doc.select("#test").first();