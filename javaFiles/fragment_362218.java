public class MySuggestOracle extends SuggestOracle {

        private List<String> data;

        public MySuggestOracle(List<String> data) {
            this.data = data;
        }

        @Override
        public void requestSuggestions(final Request request, final Callback callback) {
            String userInput = request.getQuery();
            List<Suggestion> suggestions = new LinkedList<Suggestion>();
            for (final String s : data) {
                if (s.startsWith(userInput)) {
                    suggestions.add(new Suggestion() {
                        @Override
                        public String getReplacementString() {
                            return s;
                        }

                        @Override
                        public String getDisplayString() {
                            return s;
                        }
                    });
                }
            }
            Response response = new Response(suggestions);
            callback.onSuggestionsReady(request, response);
        }
    }