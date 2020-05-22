ArrayList<LocationDistances> min=new  ArrayList<LocationDistances>();

for(LocationDistances x:locsDis){
    if(min.size()==0||x.distances==min.get(0).distances)
           min.add(x);
    else if(x.distances<min.get(0).distances){
           min.clear();
           min.add(x);
    }               
}