String q= "\u6771\u65e5\u672c\u5927"; // 東日本大

String url= "http://example.com/query?q="+URLEncoder.encode(q, "utf-8");
// http://example.com/query?q=%E6%9D%B1%E6%97%A5%E6%9C%AC%E5%A4%A7

response.sendRedirect(url);