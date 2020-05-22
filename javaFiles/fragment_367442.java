class MyClassFactory{
    public:
      MyClass* init(int idx, std::string val){
        switch(idx){
        case 1:
            return new Concrete_1;
        default:
            return nullptr;
        }
    }
};