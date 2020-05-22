@members {
    ArrayList<String> keyList = .... // get dynamic list of keywords

    public boolean inList(String id) {
        return keyList.contains(id) ;
    }
}

parent   : special   // dynamic keywords
         | variable  // everything else
         ;
special  : ID { inList($ID.getText()) }? ;
variable : ID ;