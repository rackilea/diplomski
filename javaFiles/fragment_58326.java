public static class EUtils<E extends Enum<E>> {

    private final E[] values;
    private Function<String,E> valueOf;

    public EUtils(E[] values, Function<String,E> valueOf) {
        this.values = values;
        this.valueOf = valueOf;
    }

    public List<String> supported(){
        return Arrays.asList(values)
                     .stream().map(Enum::name).collect(Collectors.toList());
    }

    public boolean contains(String value){

        boolean response = false;

        try {
            response = value != null ? valueOf.apply(value.trim().toUpperCase()) != null : false;

        } catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}



private enum Directions {
    LEFT,
    RIGHT;

    public static EUtils<Directions> enumUtils = new EUtils<>(Directions.values(),Directions::valueOf);

}


public static void main(String[] args) {
    System.out.println(Directions.enumUtils.contains("LEFT"));
    System.out.println(Directions.enumUtils.contains("X"));
}