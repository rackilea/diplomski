String pageIdUrl = response.getRedirectUrl();

if(pageIdUrl.startsWith(conf.toString()))
{
    pageIdUrl = pageIdUrl.substring(conf.toString().length());
}
Console.WriteLine(conf.toString());
Console.WriteLine(pageIdUrl);