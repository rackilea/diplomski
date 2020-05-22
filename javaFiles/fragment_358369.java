public class AWrapper<T extends A>
{
    public T member;
    public AWrapper(T member)
    {
        this.member = member;
    }

    public void doStuffWithMember()
    {
        a.doStuff();
    }
}    

public class BWrapper extends Wrapper<B>
{
    public BWrapper(B member)
    {
        super(member);
    }

    public void doStuffWithMember()
    {
        member.doMoreStuff();
    }
}