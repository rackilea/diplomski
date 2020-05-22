WebClient webClient = new WebClient();
   XHtmlPage page = webClient.getPage("…");
   HtmlElement div = page.getHtmlElementById("elem_container");
   WebWindow window = webClient.getCurrentWindow();
   Window jscript = (Window) window.getScriptObject();
   HTMLElement element = (HTMLElement) jscript.makeScriptableFor(div);
   ComputedCSSStyleDeclaration style = jscript.jsxFunction_getComputedStyle(element, null);
   System.out.println(style);