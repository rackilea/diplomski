function getItems(jsonArray) {
    var list = [];

    for (var i = 0; i < jsonArray.length; i++) {
       list.push(jsonArray[i].Item.Value);
    }

    return list;
}