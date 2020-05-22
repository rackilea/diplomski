for(int i = upList.size()-1;i>=0;i--){    
    if(upList.get(i).startsWith("r")||upList.get(i).startsWith("g")){
        upList.remove(i);        
    }
}
System.out.println("Updated "+upList);
}