public static void main(String[] args) {
    ArrayList<String> a=new ArrayList<String>();
    ArrayList<String> b=new ArrayList<String>();

    //new Collection
    ArrayList<String> c=new ArrayList<String>();

    a.add("hi");
    a.add("there");
    a.add("how");
    a.add("are");

    b.add("how are you?");
    b.add("I'm fine!");
    b.add("What about you");
    b.add("Hello you there?");

    for(String s: b){
        for(String s2: a){              
            if(s.contains(s2)){
                c.add(s);
                break;
            }
        }
    }
    System.out.println(c);
}