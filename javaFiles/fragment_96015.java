public void function(IType item) {
    for (String str : item.getAllItems()) { // DOESN'T WORK! Incompoatible
                                            // types. Required String,
                                            // Found: Object
    }
}