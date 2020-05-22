public class Animal<E> {

    CollectFoodBehaviour<E> collectFoodBehaviour;

    public  void goToGetFood(E food){
        collectFoodBehaviour.collectFood(food);
    }
}