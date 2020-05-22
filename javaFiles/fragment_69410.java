public function void analyze(Element element) {
    for (Element child : (List<Element>) element.elements()) {
        if (child.getName().equals("xx")) {
            String cap = child.attributeValue("cap").trim();
            String act = child.attributeValue("act").trim();
            map.put(cap,act);
        } else if(child.getName().equals("xxt")){
            analyze(child);
        }
    }
}

// To start recursivity
analyze(minfo);