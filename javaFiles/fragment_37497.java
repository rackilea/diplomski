Comparator<Class> classComp = new Comparator<Class>()
{
    @Override
    public int compare(Class o1, Class o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
};
TreeSet<Class> classes = new TreeSet<Class>(classComp);