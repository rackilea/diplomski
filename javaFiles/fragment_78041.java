TreeElementClass root = getElementRecursive(data)

TreeElementClass getElementRecursive(JsonObject obj){
    TreeElementClass parent = new TreeElementClass();
    ...some initialization of the parent element...
    for(JsonObject child : obj.get("children").asArray()){
        parent.addChild(getElementRecursive(child))
    }
    return parent;
}