public interface BaseServices<T extends BaseBO> {

    boolean validate(T item, int id) throws Exception;
}

public interface CategoryServices 
    extends BaseServices<CategoryBO> {
}

public class BaseServicesImpl<T extends BaseBO> 
    implements BaseServices<T> {

    @Override
    public boolean validate(T item, int id) throws Exception {
        return true;
    }
}

public class CategoryServicesImpl 
    extends BaseServicesImpl<CategoryBO> 
    implements CategoryServices {

    @Override
    public boolean validate(CategoryBO item, int id) throws Exception {
        return true;
    }
}