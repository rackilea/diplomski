Public class Sentence {

        private String subject;
        private String verb;
        private String adjective;
        private String object;

    //package private to ensure no one can call it outside package, canbe made pvt as well
        Sentence(String subject, String verb, String adjective, String object) {
            this.subject = subject;
            this.verb = verb;
            this.adjective = adjective;
            this.object = object;
        }

        public static class SentenceBuilder{
            private String subject;
            private String verb;
            private String adjective;
            private String object;

            private static final String EMPTY = "";

            private String sanitizeInput(String input){
                if (input==null){
                    return EMPTY;
                }
                return input;
            }

            private String validateInput(String input){
                if(input==null || input.isEmpty()){
                    throw new IllegalArgumentException("cant be null or empty"); 
                }
                return input;
            }

            public SentenceBuilder(String subject, String verb) {
                this.subject = validateInput(subject);
                this.verb = validateInput(verb);
            }

            public SentenceBuilder adjective(String adjective){
                this.adjective = sanitizeInput(adjective);
                return this;
            }

            public SentenceBuilder object(String object){
                this.object = sanitizeInput(object);
                return this;
            }

            public Sentence build(){
                return new Sentence(subject,verb,adjective,object);
            }
        }

        public static void main(String[] args) {
//sample usage            
Sentence sentence = new SentenceBuilder("subject","verb")
                    .adjective("adjective")
                    .object("object")
                    .build();
        }
    }