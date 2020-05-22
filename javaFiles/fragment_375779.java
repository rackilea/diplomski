MyClass(int id, int amount){
    super(choseName(id),amount);
}

private static String choseName(int id){
    if (id==1) 
        return "foo";
    else 
        return "bar";        
}