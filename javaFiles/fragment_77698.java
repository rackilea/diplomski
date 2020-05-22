String[] memberToFindParts = memberToFind.split("\\,");
if(memberToFindParts.length == 2) {
    /*
     * search by fullname
     */
} else if(memberToFindParts == 1) { // Note currently you have namelenght==0 here and that's wrong
    /*
     * search by firstname and lastname separately
     */
} else {
    // input unexpected (0 or more than 2 words)
}