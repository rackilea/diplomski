for(IDynamicAction<User> action : actions){
if(action.select(instance)){
    String s = action.action(instance);
    System.out.println(s);
    break;
}