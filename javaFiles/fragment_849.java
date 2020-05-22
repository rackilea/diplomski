public class FoodBean{

public FoodBean(){}

private String foodName;
// other fields which you wana set or get

public void setFoodName(String foodName){
 this.foodName = foodName;
}

public String getFoodName(){
    return this.foodName;
  }
// override the toString() if you want the object to represent the foodName stored

@Override
public String toString(){
 return this.foodName;
  }
}