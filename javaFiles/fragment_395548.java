while ( (inscan.hasNext()) ){
    String val = inscan.next();
    if(val.equals("!"))
        break;                      
    stk.push(Integer.parseInt(val));     
}