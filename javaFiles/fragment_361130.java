class Foobar {
    public List<String> listMember;
    public String       primitiveMember;

    public Foobar() {
        listMember = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        primitiveMember = "testABC";
    }

    public Foobar(List<String> list, String primitive) {
        this.listMember = list;
        this.primitiveMember = primitive;
    }

    // Use a copy constructor instead of the Cloneable interface
    public Foobar(Foobar foobar) {
        this.primitiveMember = foobar.primitiveMember;
        this.listMember = new ArrayList<String>(foobar.listMember);
    }

    public static void main(String[] args) {
        // Create list of Foobar
        List<Foobar> foobars = new ArrayList<Foobar>();
        foobars.add(new Foobar());

        // Copy list of Foobar with the copy constructor
        List<Foobar> foobarsCopy = new ArrayList<Foobar>(foobars.size());
        for (Foobar f : foobars) {
            foobarsCopy.add(new Foobar(f));
        }

        // add a new Foobar instance (hashcode will be different now)
        foobarsCopy.add(new Foobar(new ArrayList<String>(Arrays.asList("d", "e", "f")), "foo"));

        // Modify source list (hashcode again will be different)
        foobars.get(0).listMember.add("-1-");

        // Output of references
        System.out.println("Sourcelist has size of: " + foobars.get(0).listMember.size());
        System.out.println("Destinationlist has size of: " + foobarsCopy.get(0).listMember.size());
        System.out.println("Function 'Collections.copy(...) does not copy list members of members?: "
                + (foobars.get(0).listMember.size() == foobarsCopy.get(0).listMember.size()) 
                + "\n - References: " + foobars.get(0).listMember.hashCode() 
                + " vs " + foobarsCopy.get(0).listMember.hashCode());

    }

}