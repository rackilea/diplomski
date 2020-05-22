public class Data<T, D extends Data<T, D>> {

    private List<T> data;

    public List<T> getData() {
        return this.data;
    }


    public D setData(List<T> data) {
        this.data = data;
        return (D) this;
    }

    public D getAsNullIfEmpty() {
        if (this.data == null || this.data.isEmpty())
            return null;
        return (D) this;
    }

}
public class IntegerData extends Data<Integer, IntegerData> { ... }