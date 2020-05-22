public class Doc2 {

    @XmlElement(type = Outter2.class, name= "Outter")
    private List<Outter> outters;

    public static class Outter2 extends Outter {

        @Override
        @XmlElement(type = Outter2.class, name = "Inner")
        public List<Inner> getInner() {
            return super.getInner();
        }

        @Override
        public void setInner(List<Inner> innards) {
            super.setInner(groups);
        }

        public static class Inner1 extends Inner<ProblemType2> {
            @Override
            @XmlElement(type = ProblemType2.class, name = "ProblemType")
            public List<ProblemType> getProblemTypes() {
                return super.getProblemTypes();
            }

            @Override
            public void setProblemTypes(List<ProblemType> transactions) {
                super.setProblemTypes(transactions);
            }
        }
    }
}