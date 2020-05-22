public double findAverage(ArrayList<Integer> numbers){
    int sum=0;
    for (Integer i: numbers){
        sum+=i;
    }
    return sum/(double)numbers.size();
}