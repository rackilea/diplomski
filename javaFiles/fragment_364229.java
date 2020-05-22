class Object
{
public:
    virtual Object invoke(const char *name, std::list<Object> args);
    virtual Object get_attr(const char *name);
    virtual const Object &set_attr(const char *name, const Object &src);
};