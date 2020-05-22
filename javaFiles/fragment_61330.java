public class LV {
    HashSet<AbstractModule> ams;

    public LV(HashSet<AbstractModule> abstractModules) {
        this.ams = abstractModules;
    }

    public Collection<AbstractModule> getAbstractModules() {
        return ams;
    }
}