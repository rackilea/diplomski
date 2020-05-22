public interface dataModel {
   //nothing
}
public interface dataRepo<T extends dataModel> {
    public doIt(T a);
}
public class concreteDataModel implements dataModel {
    public doIt(dataModel a);
}
public class concreteDataRepo implements dataRepo<concreteDataModel> {
    public doIt(concreteDataModel a);
}