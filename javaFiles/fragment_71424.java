public int compareTo(Vehicle v) {       
    int returnValue = Integer.compare(this.parkDate.getYear(), 
            v.parkDate.getYear());
    if (returnValue != 0) {
        return returnValue;
    }
    returnValue = Integer.compare(this.parkDate.getMonth(), 
            v.parkDate.getMonth());
    if (returnValue != 0) {
        return returnValue;
    }
    returnValue = Integer.compare(this.parkDate.getDay(), 
            v.parkDate.getDay());
    if (returnValue != 0) {
        return returnValue;
    }
    returnValue = Integer.compare(this.parkDate.getHours(), 
            v.parkDate.getHours());
    if (returnValue != 0) {
        return returnValue;
    }
    return Integer.compare(this.parkDate.getMinuets(), 
            v.parkDate.getMinuets());
}