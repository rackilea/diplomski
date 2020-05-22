Map<String, ExpAdminBean> map = ~~~~~~ ;
for(ExpAdminBean exp : listaExpAdminAux) {
    if(!map.containsKey(exp.getNroDocumento())
        map.put(exp.getNroDocumento(), exp);                
} 
//if you need to put the values in a list you can do ...
ArrayList<ExpAdminBean> theList = new ArrayList<>(map.size());
theList.addAll(map.values());