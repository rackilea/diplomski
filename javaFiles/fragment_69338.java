public class Order{
private int tillID;
private int foodID;
public Order(int food, int till){
    tillID = till;
    foodID = food;
}

int getFoodId(){
    return foodID;
}

int getTillId(){
    return  tillID;
}

}