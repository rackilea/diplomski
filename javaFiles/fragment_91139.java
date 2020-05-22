Nodes childNodes = parent.query("child");
for (int i = 0; i < childNodes.size(); i++) {
    Element currentChild = (Element) childNodes.get(i);
    if (someCondition) {
        ParentNode parent = currentChild.getParent();
        int currentIndex = parent.indexOf(currentChild);
        currentChild.detach();
        Element extraParent = new Element("extraParent");
        extraParent.appendChild(currentChild);
        parent.insertChild(extraParent,currentIndex);
    }
}