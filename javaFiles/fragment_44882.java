// NOTE: THIS PIECE OF CODE ASUMES THAT Fragment IS THE SUPERCLASS OF ALL IMPLEMENTATIONS IN THE LIST!
    List<Class<? extends Fragment>> l = new ArrayList<>();//This is your list of fragments
    Fragment fragmentObject = (Fragment) l.get(3).newInstance();//use default constructor with no arguments. I am randomly getting index 3
    Bundle arguments = new Bundle();
    arguments.putInt("someValue",123);
    fragmentObject.setArguments(arguments);