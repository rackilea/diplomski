/**
 * position: where in the arraylist to store. 
 * newvalue: the value to set
 */
 public void setPositionValue(int position, int newvalue) {
    /** check if valid arraylist index **/
    if(position < this.arraylist.size()) {
        MyObject myobject = this.arraylist.get(position);
        /** check if we got something valid back **/
        if(myobject != null) { 
           /** check if array is set and length is valid **/
           if(myobject.position != null && myobject.position.length > 1) {
               myobject.position[1] = newvalue;
           }
        }
    }

}