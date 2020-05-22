class Priorityy implements Comparable<Priorityy> {
    public int compareTo(Priorityy pe) {
        if (pe != null) {
            return Integer.compare(this.key, pe.key);
        } else {
            // return what ever if pe is null
        }
    }
}