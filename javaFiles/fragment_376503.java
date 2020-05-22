for(Iterator<Apple> iterator = apples.iterator(); iterator.hasNext();) {
    Apple apple = iterator.next();
    if(apple.getColour().equals(colour)) {
        dosomething();
        return apple;
    }
 }