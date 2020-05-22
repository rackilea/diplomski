// Note: the class doesn't need to be public, since anybody that uses
// it can just declare their variable as type WebPage
class Page1 extends WebPage {
  @Override protected String renderBodyHtml() {
    return "<body>Hello world!</body>";
  }

  @Override public String getNameToLinkTo() {
     return "Page1";
  }
}