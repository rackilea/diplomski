public static int countByWeight(ArrayList<CandyBar> list, double weight)
{
    int countOfBarsHeavierOrEqual = 0;
    for(int i = 0; i < list.size(); i++){
        if(list.get(i).getWeight() >= weight){
            countOfBarsHeavierOrEqual++; 
        }
    }
    return countOfBarsHeavierOrEqual;
}