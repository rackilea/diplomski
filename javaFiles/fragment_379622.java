<T extends Number> ArrayList<T> createAList(Class<T> type)  
{
    ArrayList<T> toReturn = new ArrayList<>();
    return toReturn;
}


ArrayList<Integer> intList = createAList(Integer.class);