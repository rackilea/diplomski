public void checkNullReference(){
    ConsumerName name =  addReference();
    System.out.println(name.getConsumerName());
}

public ConsumerName addReference(){
    ConsumerName name = new ConsumerName();
    name.setConsumerName("KRISHNA");
    return name;
}