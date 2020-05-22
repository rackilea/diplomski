static String wordToFind = "...";
  public void visit(Page page) {          
            if (page.getParseData() instanceof HtmlParseData) {
                    HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                    String text = htmlParseData.getText();
                    if(text.indexOf(wordToFind)!=-1)
                            saveToDB(page.getWebURL().getURL()):
            }
  }