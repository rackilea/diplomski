private void Login() throws FailingHttpStatusCodeException, MalformedURLException, IOException
        {
            WebClient client = new WebClient();
            client.setJavaScriptEnabled(false);
            HtmlPage page = client.getPage("http://svergja.com/forum/");

            HtmlForm form = (HtmlForm) page.getElementById("navbar_loginform");

            HtmlTextInput username = (HtmlTextInput) page.getElementById("navbar_username");
                username.setValueAttribute("stackoverflow");
            HtmlPasswordInput password = (HtmlPasswordInput) page.getElementById("navbar_password");
                password.setValueAttribute("stackit123");
            HtmlSubmitInput button = form.getInputByValue("Log in"); 
            page = button.click();

            List<HtmlAnchor> anchorList = page.getAnchors();
                for (HtmlAnchor htmlAnchor : anchorList) {
                    if(htmlAnchor.getAttribute("href").contains("member.php?"))
                    {
                        page = htmlAnchor.click();
                    }
                }

                HtmlSpan span = (HtmlSpan) page.getElementById("userinfo");
                DomNodeList<DomNode> nodeList = span.getChildNodes();

                    for (DomNode domNode : nodeList) {

                        NamedNodeMap map = domNode.getAttributes();
                        Node node = map.getNamedItem("class");
                          if(node != null && node.getNodeValue() != null && node.getNodeValue().equals("usertitle"))
                          {
                                System.out.println("The usergroup is "+domNode.getTextContent());
                          }
                    }
            }