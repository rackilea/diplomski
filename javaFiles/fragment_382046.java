private String spaces(int count){
    String spaces="";
    while(count>0){
        spaces=spaces+"  ";
        count=count-1;
    }
    return spaces;
}

private String toString(int depth){
    String str="";
    if(left!=null)
    {
        str=str+left.toString(depth+1);
    }
    str=str+spaces(depth)+data.toString()+"\n";
    if(right!=null)
    {
        str=str+right.toString(depth+1);
    }
    return str;
}

private String toString(String str){
    if(left!=null)
        str=str+left.toString("  ");
    str=str+data.toString()+"\n";
    if(right!=null)
        str=str+right.toString("  ");
    return str;
}