Arrays.sort(appleArray, new Comparator<Apple>(){  
    @Override  
    public int compare(Apple apple1, Apple apple2){  
         return apple1.weight - apple2.weight;  
    }  
});