//doubleVal is the value you are looking to set.
public void setValue(...) {
    try {
        // set the field
       doubleVal = Double.parseDouble(inputvalue);
    } catch ( NumberFormatException  e) {
        doubleVal=0.0;//default
    }
}