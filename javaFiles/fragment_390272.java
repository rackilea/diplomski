If (webClient.getPage("secondurl") instanceof HtmlPage){
downloadPage = (HtmlPage) webClient.getPage("secondurl");
}
else{
//do something
}