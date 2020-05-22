interface BaseInterface<T extends BaseDTO>
{
    void run(T dto);
}

class BaseService<T extends BaseDTO> implements BaseInterface<T>
{
}

class CustomService extends BaseService<CustomDTO>
{
}