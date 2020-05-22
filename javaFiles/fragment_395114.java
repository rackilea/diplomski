protected StringBuilder setOne(){
    StringBuilder builder=new StringBuilder();
    try{
        builder.append("Cool");
        StringBuilder ret = builder.append("Return"); // 1
        return ret; // 2
    }finally{
        builder.append("+1"); //3
    }
}