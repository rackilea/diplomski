private String getValueIgnoreCase(Attributes attributes, String qName){
    for(int i = 0; i < attributes.getLength(); i++){
        String qn = attributes.getQName(i);
        if(qn.equalsIgnoreCase(qName)){
            return attributes.getValue(i);
        }
    }
    return null;
}