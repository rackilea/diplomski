Document document = Jsoup.parse(HTML);

Element element = getElementUsingXpath(); // this is working fine 

String originalText = element.text();

String changedText = originalText.substring(0, 6 + 1)
                    + "<strong>"
                    + originalText.substring(6 + 1) +"</strong>";