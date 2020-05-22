final DomNodeList<HtmlElement> scriptElements = html.getElementsByTagName("script");
if (!scriptElements.isEmpty()){
    for (HtmlElement scriptElement : scriptElements){   
        scriptElement.removeAllChildren();
    }
}