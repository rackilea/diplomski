%module pub

%include "std_vector.i"

%inline %{

enum class BeerType
{
    House,
    Lager,
    Pale,
    IPA
};

class Beer
{
public:
    Beer() : type{BeerType::House}, price{5.99f} {}
    ~Beer() = default;

    BeerType getType() {return this->type; }
    float getBeerPrice() {return this->price; }

private:
    BeerType type;
    float price;

    void setPrice(float price) { this->price = price; }
    void setType(BeerType type) { this->type = type; }
};

%}

%template(SwigVector) std::vector<Beer>;

%inline %{

class Pub
{
public:
    virtual ~Pub() = default;
    virtual void initOrder() = 0;
    virtual std::vector<Beer> getBeers() = 0;
    virtual void generateBill() = 0;
};

class MyPub : public Pub
{
public:
    void initOrder() override {}
    std::vector<Beer> getBeers() override { return {Beer(),Beer()}; }
    void generateBill() override {}
};

%}