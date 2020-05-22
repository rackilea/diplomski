Handler defaultHandler = ...

if(commandMap.containsKey(someCondition)){
    commandMap.get(someCondition).handle(this);
}else{
    defaultHandler.handle(this);
}