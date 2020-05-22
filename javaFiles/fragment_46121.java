class Component 
{
public:
    virtual ~Component() {}
    virtual int getFamilyId() const = 0;
};

// each instance is assigned a unique int at construction
class FamilyId 
{ 
    static int numberOfExistingIds = 0;
    int id;
public:
    FamilyId() : id( numberOfExistingIds++ ) {}
    int getId() const { return id; }
};

// implementation is done only in this template class
template <typename Derived, typename Base = Component> 
class ComponentImpl : public Base 
{
    static FamilyId familyId; // one instance per class for unique id
public:
    virtual int getFamilyId() const 
    { 
        assert( typeid(*this) == typeid(Derived) ); 
        return familyId.getId(); 
    }
};