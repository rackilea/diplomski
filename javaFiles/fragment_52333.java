public static void main(String[] args) {
    List<Serializable> serializables = new ArrayList<Serializable>();
    serializables.add(new RandomClass1());
    serializables.add(new RandomClass2());
    process(serializables);
    process2(serializables);//no issues

    List<RandomClass1> randomClassList = new ArrayList<RandomClass1>();
    randomClassList.add(new RandomClass1());
    randomClassList.add(new RandomClass1());
    process(randomClassList);
    process2(randomClassList);//compile time error in this line
}


private static void process(List<? extends Serializable> list){
    Iterator<? extends Serializable> itr = list.iterator();
    while (itr.hasNext()){
        Serializable s = itr.next();
        System.out.println("process1: " + s.getClass());
    }
}    

private static void process2(List<Serializable> list){
    Iterator<Serializable> itr = list.iterator();
    while (itr.hasNext()){
        Serializable s = itr.next();
        System.out.println("process2: " + s.getClass());
    }
}