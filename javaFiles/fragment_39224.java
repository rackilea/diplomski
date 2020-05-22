public class ExampleHandler2 implements RequestHandler<String, Speech> {

    public static class Speech {
        private String speech;
        public String getSpeech() {
            return speech;
        }
        public void setSpeech(String speech) {
            this.speech = speech;
        }
    }

    @Override
    public Speech handleRequest(String input, Context context) {
        Speech speech = new Speech();
        speech.setSpeech("hello theres");
        return speech;
    }
}