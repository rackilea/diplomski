class C {   
    private:
         static int c;  // Declaration of c.
    public:
         C(){ c++; }
         static int getC () { return c; }
};