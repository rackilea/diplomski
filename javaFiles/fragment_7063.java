public static void main(String[] args) {
    ArrayList subList = new ArrayList();
    subList.add("1");
    subList.add("2");
    subList.add(null);
    subList.add(null);
    subList.add("3");
    subList=leftShift(subList);
}

public static ArrayList leftShift(ArrayList x){
    ArrayList temp=new ArrayList();
    int count=0;
    for(Object t:x){
        if(t!=null)
            temp.add(t);
        else
            count++;
    }
    for (int i=0;i<count;i++)
        temp.add(null);
    return temp;
}