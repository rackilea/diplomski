while (br.ready())  {
    reqs += (char) br.read();
}
HttpRequest hr = new HttpRequest(reqs);
HttpResponse res = new HttpResponse(hr);
pw.write(res.response.toCharArray());