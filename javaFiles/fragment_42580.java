public long deleteFirst()
{
    if ( first != null ) {
        Link temp = first;
        first = first.next;
        return temp.dData;
    }
    else {
        return whateverIndicatesTheListIsAlreadyEmptyWhichMayBeHardWithReturnTypelong;
    }
}