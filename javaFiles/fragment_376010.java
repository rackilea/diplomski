public Object parseJsonElement(Token t){
    if (t.isArrayStart()){
       // is an array so create list and put child elements into list
        List list = new List();
        t = nextToken(t);
        while (!t.isArrayEnd()){
           list.add(parseJsonElement(t));
        }
        return list;
    }else if (t.isObjectStart()){
       // is an object so return parsed object
        return parseJsonElement(t);
    }else // handle something else
}