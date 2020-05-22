public static void main(String[] args) {
    LinkedList<LinkedList<String>> data=new LinkedList<>();
    LinkedList<String> subData=new LinkedList<>();

    subData.add("element1");
    data.add(subData);
    Iterator<LinkedList<String>> x = data.listIterator(0);
    while(x.hasNext()){
        LinkedList<String> obj=x.next();
        System.out.println(obj.get(0));
    }
}