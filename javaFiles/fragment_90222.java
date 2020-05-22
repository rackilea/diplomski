public interface Client<Data extends GenericData> {
    public boolean LoadData(Data data);
}

public class IntegerClientImpl implements Client<IntegerData> {
    @Override
    public boolean LoadData(IntegerData data){
        // ...
    }
}