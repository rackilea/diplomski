class Animal {
public: 
    virtual void makeSound() { std::cout << "From Animal\n"; }
};

class Dog : public Animal {
public:
    void makeSound() { std::cout << "From Dog\n"; }
};

int main() {
    Animal *a = new Animal();
    Dog* d = dynamic_cast<Dog*>(a);
    if (d == nullptr) {
        std::cout << "cast failed\n";
    } else {
        d->makeSound();
    }
}