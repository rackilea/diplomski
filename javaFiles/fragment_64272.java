Document doc = ???;
HTMLDocument htmlDoc = (HTMLDocument)doc;
final HTMLBodyElement body = (HTMLBodyElement)htmlDoc.getBody();

//JS [window] access
DOMWindowImpl wnd =
        (DOMWindowImpl)((DocumentView)htmlDoc).getDefaultView();

//Style access
CSSStyleDeclaration style = wnd.getComputedStyle(body, "");
assertEquals("Style extraction", "blue", style.getPropertyValue("background-color"));