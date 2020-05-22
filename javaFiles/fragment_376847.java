class Singleton
{
private:
    static Singleton *instance;
    int x; // global variable in disguise
    Singleton() : x(0) {}
public:
    static Singleton &instance()
    {
        // ignoring any concurrency issues for
        // simplicity's sake, don't try this at
        // home

        if (instance == nullptr)
        {
            instance = new Singleton;
        }
        return *instance;
    }

    void setX(int newX) { x = newX; }
    int getX() const { return x; }
};