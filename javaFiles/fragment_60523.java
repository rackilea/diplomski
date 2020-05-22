class Callback {
public:
    virtual ~Callback() { std::cout << "Callback::~Callback()" << std:: endl; }
    virtual void run(Parent& p) {
        std::cout << "Callback::run1(" << p.getName() << ")\n";
    }

    virtual void run(Child& c) {
        std::cout << "Callback::run2(" << c.getName() << ")\n";
    }
};