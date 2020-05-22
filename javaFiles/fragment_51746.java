for(int i=0;i<names.size();i++){
    int index=0;
    for(int j=0;j<i;j++){
        if(names.get(i).equals(names.get (j)){
             index++;
        }
    }
    if(index==0){
        System.out.println(names.get(i));
    }else{
        System.out.println(names.get(i) + index);
    }
}