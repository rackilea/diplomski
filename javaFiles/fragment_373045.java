public static ArrayList<Integer> fillArray(int size,int lowerBound,int upperBound){
    ArrayList<Integer> a = new ArrayList<Integer>(size);
    for (int count =0;count < size;count++){
       Integer rand = new Integer(randomNum(lowerBound,upperBound));
       a.add(rand);
    }
    return a;
}