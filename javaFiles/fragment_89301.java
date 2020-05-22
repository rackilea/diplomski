function handleComplexSorting( sortingObject, first, second ) {
    var result:int = 0;
    //Extracting the property name of first/second will differ, 
    //but pretty sure this is how you do it in AS3.
    var firstValue:int = findSortValueForProperty(first[0], sortingObject[0]);
    var secondValue:int = findSortValueForProperty(second[0], sortingObject[0]);

    if( firstValue > secondValue ) {
        //firstValue should go first.
        result = -1;
    }
    else if(firstValue < secondValue){
        //secondValue should go first.
        result = 1;
    }
    else {//equal
        var childSortingObject:Object;
        if( hasChildSorting(sortingObject, childSortingObject) ){
            //return result of recursion
            result = handleComplexSorting(childSortingObject, first, second);
        }
        else {
            result = 0;
        }
    }
    return result;
}