static class Glossary {

    private String term;

    public Glossary(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }
}

public static void main(String[] args) {
    List<Glossary> glossary = new ArrayList<>();
    glossary.add(new Glossary("one or two"));
    glossary.add(new Glossary("Sprint0"));
    glossary.add(new Glossary("Sprint"));

    System.out.println(findGlossaryTerms("Sprint0 is typically a one or two week period at the end of the Define phase.", glossary));
}