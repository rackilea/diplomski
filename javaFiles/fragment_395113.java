protected StringBuilder setOne(){
    StringBuilder builder=new StringBuilder();
    try{
        builder.append("Cool");
        return builder.append("Return");
    }finally{
        builder.append("+1");
    }
}