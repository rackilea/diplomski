List<DomNode> companies = (List<DomNode>) page.getByXPath("//li[contains(@class, 'featured block']");
        for (DomNode node : companies) {

                // retrieve telephone number
                DomNode telephone = (DomNode) node.getByXPath(
                        "div[@class='listingWrapper']/div[@class='itemInfo']/span[@class='tel']").get(0);