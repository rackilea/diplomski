public class Count {
    private int value;
    public Count() {
        value=0;
    }
    void increment() {
        value++;
    }
    void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }
}
public static boolean isAnagram(int val1, int val2) {
    Map<Character, Count> characterCountMap=new HashMap<>();
    for(char c:Integer.toString(val1).toCharArray()) {
        Count count=characterCountMap.get(c);
        if(count==null) { count=new Count(); characterCountMap.put(c, count);}
        count.increment();
    }
    for(char c:Integer.toString(val2).toCharArray()) {
        Count count=characterCountMap.get(c);
        if(count==null) { return false; }
        else { count.decrement(); }
        if(count.getValue()==0) {
            characterCountMap.remove(c);
        }
    }
    return characterCountMap.size()==0;
}