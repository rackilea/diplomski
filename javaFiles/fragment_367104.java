class A {
public:
    virtual void a() const = 0;
protected:
    virtual ~A() {
    }
};

class B : public virtual A {
public:
    virtual void b() const = 0;
protected:
    virtual ~B() {
    }
};

class C : public virtual A {
public:
    virtual void a() const override {
    }
};

class D : public C, public  B {
public:
    virtual void b() const override {
    }
};