public static void main(String[] args) {
    List<Data> list = new ArrayList<Data>();
    list.add(new Data("a", "b"));
    list.add(new Data("a", "c"));
    System.out.println(list.size()); //2
    list.remove(new Data("A", "b"));
    System.out.println(list.size()); //1
}

public static class Data {

    public String a;
    public String b;

    public Data(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Data other = (Data) obj;
        boolean sameA = (this.a == other.a) || (this.a != null && this.a.equalsIgnoreCase(other.a));
        if (!sameA) return false;
        boolean sameB = (this.b == other.b) || (this.b != null && this.b.equalsIgnoreCase(other.b));
        if (!sameB) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.a == null ? 0 :this.a.toUpperCase().hashCode());
        hash = 89 * hash + (this.b == null ? 0 : this.b.toUpperCase().hashCode());
        return hash;
    }

}