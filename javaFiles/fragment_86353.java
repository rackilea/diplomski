public class DepartmentStats {
    public String name;
    public int total = 0;
    public int activeCount = 0;
    public int inactiveCount = 0;

    public DepartmentStats() {}
    public DepartmentStats(String name) {
        this.name = name;
    }

    /**
     * equality based on dept name
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof DepartmentStats && 
               this.name.equals(((DepartmentStats) other).name);
    }

    /**
     * hash code based on dept name
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}