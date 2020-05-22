public List<Element> getElements(boolean includeOtherElement){

    if (includeOtherElement){
        List<Element> extendedList = new ArrayList<>(elements);
        extendedList.add(otherElement);
        return extendedList;
    }

    return elements;
}