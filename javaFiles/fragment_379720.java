List<Integer> w = new ArrayList<Integer>();
List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); //Use Arraylist inside

for(int i=1;i<10; i++){
    w.add(i);
    a.add(new ArrayList(w));
}

System.out.println(w);
System.out.println(a);