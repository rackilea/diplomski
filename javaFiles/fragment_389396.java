public static void main(String args[]) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.remove(2); //remove by index 
        list.remove("three");

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
   }