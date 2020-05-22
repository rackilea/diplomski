String unsafe = 
  "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";

String safe = Jsoup.clean(unsafe, Whitelist.basic());

// now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>