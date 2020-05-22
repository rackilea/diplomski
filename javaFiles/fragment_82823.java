List<Double> all=new ArrayList<Double>();
List<Double> al2=new ArrayList<Double>();
al2.add(rs.getDouble(10));
al2.add(rs.getDouble(11));
all.add(rs.getDouble(11));

for(int i=0;i<all.size()&&i<al2.size();i++){
    double x=al2.get(i);
    double y=all.get(i);
    double z=0;
    if(x>y){ //check to avoid negative subtractions result
        z=x-y;
    }
    else{
    z=y-x;
    }
    System.out.println(z); // do something with the result i am just printing it out
 }