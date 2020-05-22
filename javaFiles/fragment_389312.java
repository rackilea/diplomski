XsListGetter getter = new XsListGetter();
getter.fetchHtml();
if (getter.requestSucceeded() {
    myObjectsList = getter.parseHtmlToList();
} else {
    //Show helpful error message
}