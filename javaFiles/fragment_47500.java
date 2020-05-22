public static void main(String[] args) {
    Dictionary dict = new Dictionary();

    dict.map.put("X" + 0, 0);
    dict.map.put("X" + 1, 1);
    dict.map.put("X" + 2, 2);
    dict.map.put("X" + 3, 3);
    System.out.println(dict.contains("X2")); // true

    Dictionary dict2 = new Dictionary();
    for(int i=0; i<4; i++) {
        dict2.map.put("X" + i, i);
    }
    System.out.println(dict2.contains("X2")); // false
}