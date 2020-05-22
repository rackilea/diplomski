List<List<String>>ar1 = new ArrayList<>();
//lets say we want to have array [2, 4]
//we will initialize it with nulls
for (int i=0; i<2; i++){
    ar1.add(new ArrayList<String>());
    for(int j=0; j<4; j++)
        ar1.get(i).add(null);
}
System.out.println("empty array="+ar1);

//lets edit contend of that collection
ar1.get(0).set(1, "position (0 , 1)");
ar1.get(1).set(3, "position (1 , 3)");
System.out.println("edited array="+ar1);

//to get element [0, 1] we can use: ar1.get(0).get(1)
System.out.println("element at [0,1]="+ar1.get(0).get(1));