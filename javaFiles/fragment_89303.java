function hasChildSorting(sortingObject:Object, outChild:Object):Boolean {
    var result:Boolean = false;
        if( sortingObject[0] is Object ) {
            result = true;
            outChild = sortingObject[0];
        }
    }
    return result;
}