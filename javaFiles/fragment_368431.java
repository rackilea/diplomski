String str = "efwefewfhttp://assets.main.com/zepto-1.1.3.min.js fffhttp://assets.main.com/zepto-1.1.3.min.js";
Pattern ptrn = Pattern.compile("http://[a-z./]\\S*\\.js");
Matcher urlMatcher = ptrn.matcher(str);
List<String> kk = new ArrayList<String>();
while (urlMatcher.find()){
    kk.add(urlMatcher.group());
}
System.out.println(kk);
// [http://assets.main.com/zepto-1.1.3.min.js, http://assets.main.com/zepto-1.1.3.min.js]