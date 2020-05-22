// This line is getting the underlying array out from "this" ArrayList   
Object[] elementData = ArrayList.this.elementData; 

// I is the current value of your cursor.  Every time you call "next"
// this cursor is being incremented to get the next value
// This statement is asking if your current cursor extends beyond the
// end of the array, if it does then "Something" happened to make the array
// smaller while we weren't looking...
if (i >= elementData.length) 
    // To indicate that the elementData array has changed size outside of
    // our current iterator, throw an exception to the user.
    throw new ConcurrentModificationException();