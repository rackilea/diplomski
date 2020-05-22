List<Element> thingsToBeAdd = new ArrayList<Element>();
for(Iterator<Element> it = mElements.iterator(); it.hasNext();) {
    Element element = it.next();
    if(...) {  
        //irrelevant stuff..
        if(element.cFlag){
            // mElements.add(new Element("crack",getResources(), (int)touchX,(int)touchY));
            thingsToBeAdd.add(new Element("crack",getResources(), (int)touchX,(int)touchY));
            element.cFlag = false;
        }           
    }
}
mElements.addAll(thingsToBeAdd );