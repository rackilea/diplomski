private static class MyObject {
    private String key;
    private int value;
    private int num;

    public MyObject(String key, int value, int num) {
        this.key = key;
        this.value = value;
        this.num = num;
    }
    public String getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public int getNum() {
        return num;
    }
}

private static class KeysAndSum {
    private Set<String> keys = new HashSet<String>();
    private int sum;

    public Set<String> getKeys() {
        return keys;
    }
    public void addKey(String key) {
        keys.add(key);
    }
    public int getSum() {
        return sum;
    }
    public void addNum(int num) {
        sum += num;
    }
}

public static void main(String[] args) {
    List<MyObject> a = new ArrayList<MyObject>();
    a.add(new MyObject("Einstein", 12, 1));
    a.add(new MyObject("Princeton", 12, 4));
    a.add(new MyObject("Einstein", 16, 3));
    a.add(new MyObject("Princeton", 16, 7));
    a.add(new MyObject("Einstein", 19, 6));
    a.add(new MyObject("Princeton", 22, 6));
    a.add(new MyObject("Quantum", 12, 3));
    a.add(new MyObject("Quantum", 16, 6));

    List<String> requiredKeys = new ArrayList<String>();
    requiredKeys.add("Einstein");
    requiredKeys.add("Princeton");
    requiredKeys.add("Quantum");

    Map<Integer, KeysAndSum> map = new HashMap<>();
    for (MyObject obj : a) {
        KeysAndSum keysAndSum;
        if (map.containsKey(obj.getValue())) {
            keysAndSum = map.get(obj.getValue());
        } else {
            keysAndSum = new KeysAndSum();
            map.put(obj.getValue(), keysAndSum);
        }
        keysAndSum.addKey(obj.getKey());
        keysAndSum.addNum(obj.getNum());
    }
    for (Entry<Integer, KeysAndSum> entry : map.entrySet()) {
        boolean allFound = true;
        for (String reqKey : requiredKeys) {
            if (!entry.getValue().getKeys().contains(reqKey)) {
                allFound = false;
                break;
            }
        }
        if (allFound) {
            System.out.println(entry.getKey() + ","
                    + entry.getValue().getSum());
        }
    }
}