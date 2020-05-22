List<Food> foodDataList = new ArrayList<>();// hear you can pass any pojo class object.
Context mContext;

public FoodAdapter(List<Food> foodDataList, Context mContext) {
    this.foodDataList = foodDataList;
    this.mContext = mContext;
}