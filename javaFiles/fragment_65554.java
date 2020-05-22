Elements pgElem = doc.select("div.thumb").select("div.meta").select("[data-track]");
        Elements ownerElements = new Elements();
        for(Element element:pgElem){
            if(!element.getElementsByAttributeValueContaining("data-track","owner").isEmpty()){
                ownerElements.add(element);
            }
        }