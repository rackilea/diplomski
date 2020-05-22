public static SimpleEntry<Integer, Integer> getMaxValue(int[] values){  
    int maxValue = Integer.MIN_VALUE;
    int maxIndex = -1;
    for(int i=0;i<values.length;i++){  
        if(values[i] >= maxValue){  
            maxValue = values[i];
            maxIndex = i;
        }  
    }
    return new SimpleEntry<Integer, Integer>( maxIndex, maxValue);
}

public static void main(String[] args) {
    SimpleEntry<Integer, Integer> maxEntry = getMaxValue( new int[]{1,2,3});

    System.out.println( "value["+ maxEntry.getKey() + "] = " + maxEntry.getValue() + " is the largest element");
    //value[2] = 3 is the largest element

}