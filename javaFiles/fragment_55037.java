WebClient wc = new WebClient();
wc.Proxy = WebRequest.GetSystemWebProxy();
//wc.Headers[HttpRequestHeader.AcceptEncoding] = "gzip, deflate";
string strLogin = wc.DownloadString("http://localhost:8080/bonita/loginservice?username=walter.bates&password=bpm&redirect=false");

wc.Headers[HttpRequestHeader.Cookie] = wc.ResponseHeaders[HttpResponseHeader.SetCookie].ToString();
string strCookie = wc.ResponseHeaders[HttpResponseHeader.SetCookie].ToString();

string strProcesses = wc.DownloadString("http://localhost:8080/bonita/API/bpm/process?p=0");