class Y {
    private static HashMap<String, Object> map;

    public static void setMap(HashMap<String, Object> hash) {
        map = hash;
    }

    public static HashMap<String, Object> getMap() {
        return map;
    }
}