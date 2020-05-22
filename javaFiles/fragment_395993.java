String name[]={"a","b","a","c","a","b","c"};
int qty[]={10,20,10,40,10,40,70};
ArrayList<String>tempname= new ArrayList<String>();
ArrayList<Integer>tempqty= new ArrayList<Integer>();
for(int i=0;i<name.length;i++){
    int index=tempname.indexOf(name[i]);
    if(index==-1){
        tempname.add(name[i]);
        tempqty.add(qty[i]);
    }
    else{
        tempqty.set(index,tempqty.get(index)+qty[i]);
    }
}
for(int i=0;i<tempname.size();i++){
    System.out.printf(tempname.get(i)+" ");
}   
System.out.println();
for(int i=0;i<tempqty.size();i++){
    System.out.printf(tempqty.get(i)+" ");
}