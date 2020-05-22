List <String[]> storeInv = ...
String[] store = storeInv.get(5);

// This updates an element in one of the arrays.  (You cannot
// assign an integer literal to a String or a String array element.)
store[1] = "123";

// Compilation error!  'store' is an array, so there is no 'set' method.
store.set(5, store);

// This updates an array in the list ... but in this
// case it is redundant because the 5th list element
// is already the same object as 'store'.
storeInv.set(5, store);