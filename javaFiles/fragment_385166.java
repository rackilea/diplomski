public class AppleLister implements FruitLister<Apple> {
    @Override
    public List<Apple> returnFruits(String arg) {
            List<Apple> list = new ArrayList<Apple>();
            Apple apple = new Apple(arg);
            list.add(apple);
            return list;
    }
}