@XmlAccessorType(XmlAccessType.NONE)
    public class Doc1 {

        @XmlElement(type = Outter1.class, name = "Outter")
        private List<Outter> outters;

        public static class Outter1 extends Outter {

            @Override
            @XmlElement(type = Inner1.class, name = "Inner")
            public List<Inner> getInner() {
                return super.getInner();
            }

            @Override
            public void setInner(List<Inner> innards) {
                super.setInner(innards);
            }

            public static class Inner1 extends Inner<ProblemType1> {

                @Override
                @XmlElement(type = ProblemType1.class, name = "ProblemType")
                public List<ProblemType> getProblemTypes() {
                    return super.getProblemTypes();
                }

                @Override
                public void setProblemTypes(List<ProblemType> problemTypes) {
                    super.setProblemTypes(problemTypes);
                }
            }
        }
    }