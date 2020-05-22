class NamedList<T> extends ArrayList 
{
    private String name;

    public NamedList(String name) {
        this.name = name;
    }

    // Getters/Setters and other stuff for identifier, etc.
}

ArrayList<NamedList<String>> superList = new ArrayList<NamedList<String>>();
superList.add(new NamedList<String>("babangida"));