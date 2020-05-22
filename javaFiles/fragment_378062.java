// I took the liberty of renaming this class and it's only method
public class MyPartyFactory{

    public Party create(String name)
    {
      //TODO: sanitize `name` - check it contains no `.` characters
      Class c = Class.forName("com.example.parties."+name);
      // I'm going to take for granted that I don't have to explain how or why `party` shouldn't be an instance variable.
      Party party = (PersonalParty)c.newInstance();
      return party;
    }
}