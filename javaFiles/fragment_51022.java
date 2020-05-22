public void post() {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(link);
    String str ="Nhập nội dung bình luận để gửi đi!";
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("file", encodeHTML(str)));
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    HttpResponse response = httpclient.execute(httppost);
}
public static String encodeHTML(String s)
{
    StringBuffer out = new StringBuffer();
    for(int i=0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c > 127 || c=='"' || c=='<' || c=='>')
        {
           out.append("&#"+(int)c+";");
        }
        else
        {
            out.append(c);
        }
    }
    return out.toString();
}