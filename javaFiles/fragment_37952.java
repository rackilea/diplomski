public abstract class ArrayHolder {
    Gson g = new Gson();

    public <T> ArrayList<T> arrayType(String data){
        return g.fromJson(data, TypeToken.get(new ArrayList<T>().getClass()));
    }
}