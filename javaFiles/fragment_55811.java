// in the header
class Foo
{
public:
    Foo();
    ~Foo();

private:
    struct Pimpl; // forward declaration to internal structure
    Pimpl* m; // opaque pointer to actual data
};

// in the cpp file
struct Foo::Pimpl
{
    std::string name;
};

Foo::Foo()
    : m( new Pimpl)
{
}

Foo::~Foo()
{
    delete m;
}