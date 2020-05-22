public void replaceElement(Object current, List insertions) {

    int index = content.indexOf(current);       
    if (index > -1 ) {          
        content.addAll(index+1, insertions);  
        Object removed = content.remove(index);
        // sanity check
        if (!current.equals(removed)) {
            log.error("removed wrong object?");
        }           
    } else {
        // Not found
        log.error("Couldn't find replacement target.");
    }
}