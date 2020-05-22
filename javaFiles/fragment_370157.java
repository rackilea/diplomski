final WebClient webClient = new WebClient();

HtmlPage page = webClient.getPage("http://www.census.gov/manufacturing/m3/");

HtmlSelect select = (HtmlSelect) page.getElementByName("advanced_xls");

InputStream is =  select.setSelectedAttribute("/manufacturing/m3/adv/table2a.xls",true).getWebResponse().getContentAsStream();