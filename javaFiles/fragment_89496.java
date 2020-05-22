public Counter{
    private int count;

    public Counter(){
        count = 0;
    }

    public int getValue(){
        return count;
    }

    public void increment(){
        counter++;
    }
}

public CounterStorage(){
    private static HashMap<String, Counter> counterMap = new HashMap<>();

    public static Counter getInstance(String str){
        if (counterMap.containsKey(str)) return counterMap.get(str);

        Counter newCounter = new Counter();
        counterMap.add(str, newCounter);
        return newCounter;

    }
}