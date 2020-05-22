Set <URL>uniqueURLs = new HashSet <URL>();
      HtmlPage page=null;


   for (int i = 0; i < tableUrlSource.length; i++) {
   try {    
            if(uniqueURLs.contains(tabUrlSource[i]) continue;
            else
             uniqueURLs.add( tabUrlSource[i] );
            page = webClient.getPage(tabUrlSource[i]);
            List<HtmlElement> nbElements = (List<HtmlElement>) 
            page.getByXPath(tabXpathSource[i]);
            if (null != nbElements && !nbElements.isEmpty()) {
                htmlResult = nbElements.get(0).asText();

}