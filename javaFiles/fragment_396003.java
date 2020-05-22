Document document = Jsoup.parse(strText);
            for( org.jsoup.nodes.Element element : document.select("td:eq(5)")) {
                String content = element.getElementsMatchingOwnText("N/A").text();
                if(content.equalsIgnoreCase("N/A")) {
                    element = element.parent();
                    element.remove();
                }
            }
            strText = document.toString();