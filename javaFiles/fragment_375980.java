public boolean replaceCity(City newCity, String cityToBeReplaced) {

    CityNode temp = this._head, prev = null;

    //run thru the linked list until you find the cityToBeReplaced
    while(temp != null && !temp.getCity().getCityName().equals(cityToBeReplaced)) {
        prev = temp;
        temp = temp.getNext();
    }

    //cityToBeReplaced does not exist in the linked list
    if(temp == null) return false;

    CityNode newCityNode = new CityNode(newCity);

    //First node/head is what you want to replace
    if(this._head == temp) {
        this._head = newCityNode;
    } else {
        //Last cityNode or middle cityNode is what you want to replace
        prev.setNext(newCityNode);
    }

    newCityNode.setNext(temp.getNext());
    return true;
}