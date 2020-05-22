for(int i = 0;i<nodes.size();i++){
    if(n.compareTo(nodes.get(i))<=0 ){
        nodes.add(i,n);
        added = true;
        break;
    }
}