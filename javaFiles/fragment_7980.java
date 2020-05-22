public abstract class Contact<T>
{
    public abstract Set<T> getEventsWithinPeriod();
}

class DOB
{
}
class BMeeting
{
}

class PersonalContact extends Contact<DOB>
{
    @Override
    public Set<DOB> getEventsWithinPeriod() 
    {
        // TODO Auto-generated method stub
        return null;
    }
}


class BusinessContact extends Contact<BMeeting>
{
    @Override
    public Set<BMeeting> getEventsWithinPeriod() 
    {
        return null;
    }
}