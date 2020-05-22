Elements body = doc.select("body");
    Elements bodyChildren = new Elements();
    for (Element e : body) {
        for (Element eChild : e.children()) {
            bodyChildren.add(eChild);
        }
    }

    if (bodyChildren.hasClass("pagenav")){...