public String toString() {
    String result;

    // "ID" + id +" "
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    result = df.format(date) + "" + name + "" + Phone ; 
             ^^^^^^^^^^^^^^^
             date object is null above


    return result;
}