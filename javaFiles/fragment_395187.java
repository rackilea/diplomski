public void write(PrintWriter fromPortalTXTFile, String level) {

    . . . 

    if(children) {
        for(int n = 0; n < childrenList.size(); n++) {
            // you need to pass in the child object, unless 
            // you're controlling it with level
            write(childrenList.get(n), level);
        }
    } else {

        . . .

    }
}