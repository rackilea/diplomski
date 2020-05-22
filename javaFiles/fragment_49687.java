Scanner in = new Scanner(System.in);
Set<String> set = new TreeSet<>();

while(!in.hasNext("exit")){ //you can put any word for exit
    set.add(in.next());
}

for(String e : set){
    System.out.println(e);
}