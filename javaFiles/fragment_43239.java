public enum Position {

    ...

    Position(int code) {
        this.code = code;
        MapHolder.BY_CODE.put(code, this);
    }

    private static class MapHolder {
        private static final Map<Integer, Position> BY_CODE = new HashMap<Integer, Position>();
    }

    public static Position findByCode(int code) {
        return MapHolder.BY_CODE.get(code);
    }