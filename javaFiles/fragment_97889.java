import org.apache.commons.lang.StringUtils;

public class Program
{
    public static void main(String[] args)
    {
        User bob = new User("0001", "Bob");
        String id = bob.getId(); //stepped over
        String name = bob.getName(); //stepped over
        IHome home = bob.getHome(); //stepped into

        bob.setId("foo"); //stepped into
        bob.setName("Bobby"); //stepped over
        String asString = bob.setNameFluent("Bobbo").toString(); //stepped into
        IHome newHome = Neighborhood.getHome("moo");
        bob.setHome(newHome); //stepped into
        return;
    }

    static class User
    {
        private String id;
        private String name;
        private IHome home;

        public User() { this("0001", null); }
        public User(String id, String name) { this.id = id; this.name = name; }

        public String getId() // simple
        {
            return id;
        }
        public String getName() // simple
        {
            return name;
        }
        public IHome getHome() // not simple
        {
            if (home == null)
                home = Neighborhood.getHome(id);
            return home;
        }

        public void setId(String id) // not simple
        {
            if (StringUtils.isBlank(id))
                throw ExceptionHelper.argumentBlank("id");
            this.id = id;
        }
        public void setName(String name) // simple
        {
            this.name = name;
        }
        public User setNameFluent(String name) // not simple
        {
            this.name = name;
            return this;
        }
        public void setHome(IHome home) // not simple
        {
            if (home != null)
            {
                this.home = home;
                onHomeChanged();
            }
        }

        protected void onHomeChanged()
        {
            this.id = home.getId();
        }
        public String toString()
        {
            return "User { name=" + getName() + ", home=" + getHome() + " }";
        }
    }

    static interface IHome
    {
        String getId();
        String getLocation();
    }

    static class Neighborhood
    {
        public static IHome getHome(String id)
        {
            return new Home(id);
        }

        static class Home implements IHome
        {
            private String id;
            public Home(String id) { this.id = id; }
            public String getId() { return id; }
            public String getLocation() { return "Home" + id; }
            public String toString() { return "Home: " + getLocation(); }
        }
    }

    static class ExceptionHelper
    {
        public static IllegalArgumentException argumentBlank(String name)
        {
            return new IllegalArgumentException("Argument " + name + " must not be blank");
        }
    }
}