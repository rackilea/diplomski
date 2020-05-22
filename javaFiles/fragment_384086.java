class A
{
public:
    void *tag;
    virtual void *getTag()
    {
        return tag;
    }

    virtual void setTag(void *tag)
    {
        this->tag = tag;
    }
};

class AWrapper
{
public:
    A *a;
    AWrapper(A *a)
    {
        this->a = a;
        a->setTag(this);
    }
};