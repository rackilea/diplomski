Page page = webClient.getPage(url);
System.out.println(page);
WebResponse response = page.getWebResponse();

if (response.getContentType().equals("application/json")) 
{
pagesource = response.getContentAsString();
System.out.println(pagesource);
}