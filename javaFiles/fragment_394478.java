public class AbstractDaoImpl<S, T> {
    public AbstractDaoImpl(Class<T> clazz) {
        ...
    }
}

public class CarDaoImpl extends AbstractDaoImpl<Long, Car> implements CarDao {
    public CarDaoImpl() {
        super(Car.class);
    }
}