private static IExecutable getMenuOptions(String i){
     for(MenuOptions option :  options){
        if(i.equals(option.getKey()+"")) && option.getIsActive()){
            return option;
        }
    }
    return null;
}